package com.learn.spring;

/**
 * Author: chunxing
 * Date: 2018/7/5  下午10:09
 * Description:
 */
public class VolatileTest extends Thread {

    private volatile boolean flag = false;
    private int i = 0;

    public void run() {
        while (!flag) {
            i++;
        }
    }

    public static void main(String[] args) throws Exception {
        VolatileTest vt = new VolatileTest();
        vt.start();
        Thread.sleep(2000);
        vt.flag = true;
        System.out.println("stope" + vt.i);
    }
}
