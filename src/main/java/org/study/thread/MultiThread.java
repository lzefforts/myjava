package org.study.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by ArnoldLee on 2019/6/4.
 */
public class MultiThread {

    public static void main(String[] args) {




        ThreadPool.getInstance().getThreadPoolExecutor().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaaa");
            }
        });

        //获取java线程管理MxBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadPool.getInstance().getThreadPoolExecutor().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("sssss");
            }
        });

        //不需要获取同步的monitor和synchronized信息,仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);

        //遍历线程,仅打印线程id和名称信息
        for (int i = 0; i < threadInfos.length; i++) {
            System.out.println("["+threadInfos[i].getThreadId()+"]"+threadInfos[i].getThreadName());
        }
    }


}
