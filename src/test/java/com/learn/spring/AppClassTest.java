package com.learn.spring;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Author: chunxing
 * Date: 2018/7/6  下午3:17
 * Description:
 */
public class AppClassTest {

    public static void main(String[] args) throws Exception {

        String filePath = "/Users/abee/Desktop/";
        AppClassLoader appClassLoader = new AppClassLoader(filePath);
        appClassLoader.findClass("Loader");
        Class<?> aClass = appClassLoader.loadClass("Loader");

        Object object = aClass.newInstance();
        Method method = aClass.getMethod("getName", null);
        method.invoke(object, null);
        System.out.println(aClass.getClassLoader());
    }
}
