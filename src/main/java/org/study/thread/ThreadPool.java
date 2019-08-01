package org.study.thread;

import java.util.concurrent.*;

/**
 * 线程池
 * Created by ArnoldLee on 17/11/29.
 */
public class ThreadPool {
    // 线程池维护线程的最少数量
    private static final int COREPOOLSIZE = 10;
    // 线程池维护线程的最大数量
    private static final int MAXINUMPOOLSIZE = 50;
    // 线程池维护线程所允许的空闲时间
    private static final long KEEPALIVETIME = 10;
    // 线程池维护线程所允许的空闲时间的单位
    private static final TimeUnit UNIT = TimeUnit.SECONDS;
    // 线程池所使用的缓冲队列,这里队列大小为30
    private static final BlockingQueue<Runnable> WORKQUEUE = new ArrayBlockingQueue<Runnable>(30);
    // 线程池对拒绝任务的处理策略：AbortPolicy为抛出异常；CallerRunsPolicy为重试添加当前的任务，他会自动重复调用execute()方法；DiscardOldestPolicy为抛弃旧的任务，DiscardPolicy为抛弃当前的任务
    // private static final AbortPolicy HANDLER = new
    // ThreadPoolExecutor.AbortPolicy();

    private static ThreadPool instance = null;

    private ThreadPoolExecutor threadPoolExecutor = null;

    private ThreadPool() {
        threadPoolExecutor = new ThreadPoolExecutor(COREPOOLSIZE, MAXINUMPOOLSIZE, KEEPALIVETIME, UNIT, WORKQUEUE,
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        try {
                            executor.getQueue().put(r);
                            System.out.println("线程放入等待队列中等待!");
                        } catch (InterruptedException e) {

                        }
                    }

                });
    }

    public static ThreadPool getInstance() {
        if (instance == null) {
            instance = new ThreadPool();
        }
        return instance;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }
}