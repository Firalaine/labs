package org.chdtu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UniversityAspect {

    @Pointcut("execution(* org.chdtu.University.printInfo(..))")
    public void universityPrintInfo() {}

    @Pointcut("execution(* org.chdtu.Student.set*(..))")
    public void studentSetters() {}

    @Pointcut("execution(* org.chdtu.Group.initGroup(..))")
    public void groupInitGroupMethod() {}

    @Pointcut("universityPrintInfo() || studentSetters()")
    public void combinedPointcut() {}

    @Before("universityPrintInfo()")
    public void beforeUniversityPrint() {
        System.out.println("[AOP] Перед виконанням University.printInfo()");
    }

    @After("studentSetters()")
    public void afterStudentSetter() {
        System.out.println("[AOP] Після виклику сеттера Student");
    }

    @Around("groupInitGroupMethod()")
    public Object aroundGroupInit(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[AOP] Around Group.initGroup() — ДО виконання");
        Object result = joinPoint.proceed();
        System.out.println("[AOP] Around Group.initGroup() — ПІСЛЯ виконання");
        return result;
    }
}
