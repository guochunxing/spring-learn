package com.learn.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.time.LocalDateTime;

/**
 * Author: chunxing
 * Date: 2018/8/1  下午5:01
 * Description:
 */
@Aspect
public class AspectTest {

    @Pointcut("@annotation(Timer)")
    public void anyMethod() {
    }

    @Before(value = "anyMethod()")
    public void beforeTest() {
        System.out.println(LocalDateTime.now());
    }
}
