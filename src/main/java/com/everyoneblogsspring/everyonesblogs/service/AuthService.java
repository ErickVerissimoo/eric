package com.everyoneblogsspring.everyonesblogs.service;

import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.session.Session;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.stereotype.Service;
import com.everyoneblogsspring.everyonesblogs.dto.UserDTO;
import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.repository.userRepository;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AuthService {
private final userRepository repository;
private final ModelMapper mapper;

public boolean logout(HttpServletResponse response, HttpServletRequest request){
    try{
    User user = repository.findById(UUID.fromString(request.getSession().getAttribute("id").toString())).get();
user.setSessionID(null);
var e = request.getCookies();
for(var v : e){
if(v.getName().equals("session_id")){
v.setMaxAge(0);
response.addCookie(v);
repository.saveAndFlush(user);

}}

return true;} catch(Exception e){
    System.out.println(e.getCause().getMessage());
    return false;

}
}




@Transactional
public boolean login(User user, HttpServletResponse response, HttpServletRequest request) {
    try{

    UUID userId = repository.findIdByEmail(user.getEmail());
       HttpSession session = request.getSession(true);

        if(request.getCookies()[0].getValue().equals(session.getId())){
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Usuário já logado");
            return false;
        };
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