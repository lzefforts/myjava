package org.study.thread;

import java.util.concurrent.*;

/**
 * Created by ArnoldLee on 17/11/30.
 */
public class RejectThreadPoolDemo {

    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();

        ExecutorService executorService = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(10),
                Executors.defaultThreadFactory(),
//                new ThreadFactory() {
//                    @Override
//                    public Thread newThread(Runnable r) {
//                        Thread t = new Thread();
//                        t.setDaemon(true);
//                        System.out.println("create " + t);
//                        return t;
//                    }
//                },
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + "is discard");
                    }
                });

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.submit(task);
            Thread.sleep(10);
        }

    }


}
