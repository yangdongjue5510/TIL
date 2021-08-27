package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")//컨트롤러폴더 하위 전부다 적용
    private void cut(){}

    @Before("cut()")
    public void before(JoinPoint joinPoint){
        //메소드 정보 출력하기
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());//메소드 이름 반
        //파라미터 출력하기
        Object[] args = joinPoint.getArgs();
        for(Object obj : args){
            System.out.println("method : "+obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }
    @AfterReturning(value = "cut()", returning = "obj")
    public void afterReturn(JoinPoint joinPoint, Object obj){
        System.out.println("returning");
        System.out.println(obj);
    }
}
