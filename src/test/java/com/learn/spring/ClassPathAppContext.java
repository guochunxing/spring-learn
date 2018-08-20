package com.learn.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: chunxing
 * Date: 2018/7/13  下午10:52
 * Description:
 */
public class ClassPathAppContext extends ClassPathXmlApplicationContext {

    public ClassPathAppContext(String configLocation) throws BeansException {
        super(configLocation);
    }

    @Override
    protected void initPropertySources() {
        getEnvironment().setRequiredProperties("var");
    }
}
