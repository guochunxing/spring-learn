package com.learn.spring.aop;

import java.lang.annotation.*;

/**
 * Author: chunxing
 * Date: 2018/8/1  下午4:56
 * Description:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Timer {
}
