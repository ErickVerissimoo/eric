package com.everyoneblogsspring.everyonesblogs.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.everyoneblogsspring.everyonesblogs.exceptions.LoginFailedException;

@RestControllerAdvice
public class ExceptionsConfig {
@ExceptionHandler(exception = LoginFailedException.class)

public ResponseEntity<String> response(LoginFailedException e){
    return ResponseEntity.badRequest().body("Uma exceção ocorreu: " + e.getMessage());
}
}
