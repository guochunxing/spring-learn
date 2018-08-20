package com.learn.spring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Author: chunxing
 * Date: 2018/7/6  下午2:21
 * Description:
 */
public class AppClassLoader extends ClassLoader {
    private String filePath = null;

    public AppClassLoader(String path) {
        this.filePath = path;
    }

    @Override
    protected Class<?> findClass(String name) {

        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath + name + ".class"));
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
 /* ClassPath classPath = new ClassPath("/Users/abee/Desktop/AppClassLoader.class");
        ClassPathLoader classPathLoader = new ClassPathLoader(classPath);
        Class<?> appClass = classPathLoader.loadClass("AppClassLoader");
        Object object = appClass.newInstance();
        Method method = appClass.getMethod("getName", null);
        method.invoke(object, null);
        System.out.println(appClass.getClassLoader());*/