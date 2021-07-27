package com.codegym.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int rentTimes = 0;
    private static int returnTimes = 0;
    private static int visitTimes = 0;

    @AfterReturning(pointcut = "execution(public * com.codegym.model.service.BookServiceImpl.rentBook(..))")
    public void logRentBook() {
        System.err.println("Thư viện thay đổi -> Số lần thuê sách: " + ++rentTimes);
    }

    @AfterReturning(pointcut = "execution(public * com.codegym.model.service.BookServiceImpl.returnBook(..))")
    public void logReturnBook() {
        System.err.println("Thư viện thay đổi -> Số lần trả sách: " + ++returnTimes);
    }

    @After("execution(* com.codegym.controller.BookController.showList(..))")
    public void logVisitTime(JoinPoint joinPoint) {
        System.err.println("Thư viện được ghé thăm -> Số lần thao tác: " + ++visitTimes +
                "\n\t\t-> Phương thức: " + joinPoint.getSignature().getName());
    }
}
