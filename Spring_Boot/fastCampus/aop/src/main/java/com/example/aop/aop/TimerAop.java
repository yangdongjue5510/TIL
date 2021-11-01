package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")//컨트롤러폴더 하위 전부다 적용
    private void cut(){}


    @Pointcut("@annotation(com.example.aop.annotation.Timer)")//해당 어노테이션 사용시 발동
    private void enableTimer(){}

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed(); //메소드가 실행시켜 리턴값(객체나 이런거)이 나올 경우 result에 할당

        stopWatch.stop();
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
    }
}
