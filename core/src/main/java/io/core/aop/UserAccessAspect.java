package io.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAccessAspect {


    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    @Before("execution(* io.core.beans.Business+.set*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println(" Allowed execution for {}" + joinPoint);
    }
}
