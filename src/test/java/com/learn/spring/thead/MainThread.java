package com.learn.spring.thead;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Author: chunxing
 * Date: 2018/7/18  下午4:30
 * Description:
 */
public class MainThread {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId() + "---" + threadInfo.getThreadName());
        }

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        long init = memoryMXBean.getHeapMemoryUsage().getInit();
        System.out.println("init---" + init);

        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        Integer mBeanCount = platformMBeanServer.getMBeanCount();
        System.out.println("mBeanCount---" + mBeanCount);
    }
}
