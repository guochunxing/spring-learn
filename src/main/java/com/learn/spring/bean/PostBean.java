package com.learn.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Author: chunxing
 * Date: 2018/7/15  上午11:47
 * Description:
 */
public class PostBean implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.err.println(beanName);
        return bean;
    }
}
