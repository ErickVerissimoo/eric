package com.everyoneblogsspring.everyonesblogs.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
@Component
@Aspect
@Log4j2
public class loggingAspect {
    @Before("execution(* com.everyoneblogsspring.everyonesblogs..*.*(..)) && !execution(* changeSessionId(..))")
public void loggin (JoinPoint point){
log.info("O método: " + point.getSignature().toShortString() + " está prestes a ser executado");
}
}