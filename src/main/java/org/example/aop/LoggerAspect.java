package org.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggerAspect {
    @Pointcut("@within(Loggable)")
    public void companyMethods(){}
    
    @Before("companyMethods")
    public void before(){
        log.info("Start method");
        System.out.println("BEFORE");
    }

    @After("companyMethods")
    public void after(){
        System.out.println("AFTER");
    }
    @AfterThrowing("companyMethods")
    public void afterThrowing(){
        System.out.println("Exception");
    }

    @Around("companyMethods")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("BEFORE");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("AFTER");
        return result;
    }

}
