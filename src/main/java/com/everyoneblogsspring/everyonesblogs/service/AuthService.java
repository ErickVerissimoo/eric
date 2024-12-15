package com.everyoneblogsspring.everyonesblogs.service;

import java.net.http.HttpResponse;
import java.util.UUID;

import org.springframework.http.ResponseCookie;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;
import com.everyoneblogsspring.everyonesblogs.dto.UserDTO;
import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.repository.userRepository;
import com.everyoneblogsspring.everyonesblogs.utils.UserMapper;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AuthService {
private final userRepository repository;
private final  UserMapper mapper;
private final SessionService service;

@Transactional
public boolean login(User user, HttpServletResponse response, HttpServletRequest request) {
    UUID userId = repository.findIdByEmail(user.getEmail());
    if (repository.findById(userId).isPresent()) {
        Session session = service.getSessao();
        
        
        session.setAttribute("id", userId.toString());

        User existingUser = repository.findById(userId).get();
        existingUser.setSessionID(session.getId());
        repository.saveAndFlush(existingUser);

        System.out.println("Sessão criada e usuário associado: " + session.getId());

        ResponseCookie cookie = ResponseCookie.from("session_id", session.getId())
                                              .httpOnly(true)
                                              .build();
        response.setHeader("Set-Cookie", cookie.toString());

        return true;
    }
    return false;
}
@Transactional
public boolean cadastrar(UserDTO dto){
if(!repository.existsByEmail(dto.getEmail())){
repository.saveAndFlush(mapper.toUser(dto));
return true;
}
return false;
}
}