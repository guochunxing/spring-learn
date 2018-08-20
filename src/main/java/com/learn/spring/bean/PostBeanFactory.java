package com.learn.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Author: chunxing
 * Date: 2018/7/15  上午11:54
 * Description:
 */
public class PostBeanFactory implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        int beanPostProcessorCount = beanFactory.getBeanPostProcessorCount();
        String[] singletonNames = beanFactory.getSingletonNames();
        System.err.println(beanPostProcessorCount);
        for (String singletonName : singletonNames) {
            System.err.println(singletonName);
        }
    }
}
