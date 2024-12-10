package com.everyoneblogsspring.everyonesblogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

import com.everyoneblogsspring.everyonesblogs.dto.UserDTO;
import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.repository.userRepository;
import com.everyoneblogsspring.everyonesblogs.utils.UserMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AuthService {
private final userRepository repository;
@Autowired
private  UserMapper mapper;

@Transactional

public boolean login(User user, HttpServletResponse response, HttpServletRequest request){
if(repository.findById(user.getId()).isPresent()){
    HttpSession session = request.getSession(true);
    ResponseCookie cook = ResponseCookie.from("session_id", session.getId()).httpOnly(true).build();
    response.setHeader("Set-Cookie", cook.toString());
    
    session.setAttribute("id", user.getId());
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