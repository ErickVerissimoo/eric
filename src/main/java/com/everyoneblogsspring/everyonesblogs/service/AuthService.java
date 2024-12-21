package com.everyoneblogsspring.everyonesblogs.service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.everyoneblogsspring.everyonesblogs.dto.UserDTO;
import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.repository.userRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.util.WebUtils;
@Service
@Log4j2
@RequiredArgsConstructor
public class AuthService {
private final userRepository repository;
private final ModelMapper mapper;
private final SessionService service;
public boolean logout(HttpServletResponse response, HttpServletRequest request) {

    try {
        Object sessionIdAttribute = WebUtils.getSessionAttribute(request, "id");
        if (Objects.isNull(sessionIdAttribute)) {
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


        if(Objects.nonNull(WebUtils.getCookie(request, "session_id")) ){
        var cookie = WebUtils.getCookie(request, "session_id");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }else{
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return false;
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
if (!ObjectUtils.isEmpty(WebUtils.getCookie(request, "session_id"))) {
    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Usuário já criado");
    log.error("Cookie já criado: " + WebUtils.getCookie(request, "session_id").getValue() );
    return false;
}
WebUtils.setSessionAttribute(request, "id", userId);


        User existingUser = repository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Entidade não existe"));
        log.info("Usuário encontrado: " + existingUser.getEmail());
        existingUser.setSessionID(WebUtils.getSessionId(request));

        service.addSession(existingUser.getSessionID(), existingUser.getUsername());

        repository.saveAndFlush(existingUser);

        log.info("Sessão criada e usuário associado: " +existingUser.getSessionID());


        Cookie cook = new Cookie("session_id", existingUser.getSessionID());
        cook.setPath("/");
        cook.setMaxAge(500000000);
    response.addCookie(cook);
        return true;
    }catch(Exception e){
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