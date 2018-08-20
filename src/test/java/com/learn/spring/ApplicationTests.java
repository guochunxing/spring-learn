package com.learn.spring;

import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.net.URI;


public class ApplicationTests {

    @Test
    public void contextLoads() throws IOException {
        /*XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        TestBean testBean = (TestBean) xmlBeanFactory.getBean("testBean");
        TestBean testBean2 = (TestBean) xmlBeanFactory.getBean("testBean");
        System.out.println(testBean.getName());
*/
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("file:/opt/fit2cloud/conf/fit2cloud.properties");
        String description = resource.getDescription();
        boolean exists = resource.exists();
        URI uri = resource.getURI();
        System.out.println(description);
    }
}
