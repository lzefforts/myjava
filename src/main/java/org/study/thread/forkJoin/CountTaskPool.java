package org.study.thread.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author ArnoldLee
 * @date 18/8/7
 */
public class CountTaskPool extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 10000000;//阈值
    private static final long serialVersionUID = -7019446857533104279L;
    private int start;
    private int end;
    public CountTaskPool(int start, int end) {
        this.start= start;
        this.end= end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就计算任务
        boolean canCompute = (end-start) <=THRESHOLD;
        if(canCompute) {
            for(int i =start; i <=end; i++) {
                sum += i;
            }
        }else{
            //如果任务大于阀值，就分裂成两个子任务计算
            int middle = (start+end) / 2;
            CountTaskPool leftTask =new CountTaskPool(start, middle);
            CountTaskPool rightTask =new CountTaskPool(middle + 1,end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，并得到其结果
            int leftResult=leftTask.join();
            int rightResult=rightTask.join();
            //合并子任务
            sum = leftResult  + rightResult;
        }
        return sum;
    }
    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        ForkJoinPool forkJoinPool =new ForkJoinPool();
        //生成一个计算任务，负责计算1+2+3+4
        CountTaskPool task =new CountTaskPool(1, 100000000);
        //执行一个任务
        Future result = forkJoinPool.submit(task);
        try{
            System.out.println(result.get());
        }catch(InterruptedException e) {
        }catch(ExecutionException e) {
        }
        long endTime = System.currentTimeMillis();
        long spendTime = endTime - beginTime;
        System.out.printf("spendTime:%d ms\n",spendTime);


        test();


    }

    private static void test() {
        long beginTime = System.currentTimeMillis();
        int sum = 0;
        for(int i =1; i <=100000000; i++) {
            sum += i;
        }
        System.out.println(sum);
        long endTime = System.currentTimeMillis();
        long spendTime = endTime - beginTime;
        System.out.printf("spendTime:%d ms\n",spendTime);
    }

}
