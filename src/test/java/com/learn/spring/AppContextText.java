package com.learn.spring;

import com.learn.spring.test.TestBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: chunxing
 * Date: 2018/7/13  下午6:35
 * Description:
 */
public class AppContextText {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        TestBean testBean = (TestBean) context.getBean("testBean");
        System.err.println(testBean.getName());
    }
}
