package com.everyoneblogsspring.everyonesblogs.service;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;
import com.everyoneblogsspring.everyonesblogs.dto.UserDTO;
import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.repository.userRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class AuthService {
private final userRepository repository;
private final ModelMapper mapper;
private final SessionService service;
public boolean logout(HttpServletResponse response, HttpServletRequest request) {
    try {

        Object sessionIdAttribute = request.getSession(false).getAttribute("id");
        if (sessionIdAttribute == null) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return false;


        }

        UUID userId;
        try {
            userId = UUID.fromString(sessionIdAttribute.toString());
        } catch (IllegalArgumentException ex) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);

            return false;
        }

        Optional<User> optionalUser = repository.findById(userId);
        if (optionalUser.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            log.error("Usuário não existe");
            return false;
        }

        User user = optionalUser.get();
        user.setSessionID(null);
        repository.saveAndFlush(user);

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("session_id".equals(cookie.getName())) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        service.removeSession(user.getId().toString());

        request.getSession().invalidate();

        return true;

    } catch (Exception e) {
        response.setStatus(HttpServletResponse.SC_CONFLICT);
        log.error("Erro desconhecido");
        return false;
    }
}




public boolean login(User user, HttpServletResponse response, HttpServletRequest request) {
    try{

    UUID userId =Optional.ofNullable(repository.findIdByEmail(user.getEmail())).orElseThrow(()-> new EntityNotFoundException("Id não encontrado") );
log.info("Id encontrado: " + userId);
    HttpSession session = request.getSession(true);
    Cookie[] cookies = request.getCookies();
if (cookies != null && cookies.length > 0 && cookies[0].getValue().equals(session.getId())) {
    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Usuário já logado");
    return false;
}

        session.setAttribute("id", userId.toString());

        User existingUser = repository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Entidade não existe"));
        log.info("Usuário encontrado: " + existingUser.getEmail());
        existingUser.setSessionID(session.getId());

        service.addSession(existingUser.getSessionID(), existingUser.getUsername());

        repository.save(existingUser);

        log.info("Sessão criada e usuário associado: " + session.getId());

        ResponseCookie cookie = ResponseCookie.from("session_id", session.getId())
                                              .httpOnly(true)
                                              .build();
        response.setHeader("Set-Cookie", cookie.toString());

        return true;
    }catch(Exception e){
        e.printStackTrace();
        return false;
    }


}
@Transactional
public boolean cadastrar(UserDTO dto){
if(!repository.existsByEmail(dto.getEmail())){
repository.saveAndFlush(mapper.map(dto, User.class));
return true;
}
return false;
}
}