package org.study.thread;

/**
 * Created by ArnoldLee on 2019/5/19.
 */
public class VolatileTest {
//    volatile long num = 0L;
    long num = 0L;

    public long get(){
        return num;
    }

    public void set(long input){
        num = input;
    }

    public void getAndIncrement(){
        num++;
    }

    private static VolatileExampleTest bean;

    public static VolatileExampleTest getBean(){
        return bean;
    }

    public static void setBean(VolatileExampleTest input){
        bean = input;
    }


    public static void main(String[] args) throws InterruptedException {

//        VolatileTest test = new VolatileTest();
//        for(int i=0;i<10;i++){
//            new Runnable(){
//                @Override
//                public void run() {
//                    test.getAndIncrement();
//                    System.out.println("A###increment");
//                    long result = test.get();
//                    System.out.println("A###get:"+result);
//                }
//            }.run();
//
//            new Runnable(){
//                @Override
//                public void run() {
//                    long result = test.get();
//                    System.out.println("B###get:"+result);
//                }
//            }.run();
//
//            new Runnable(){
//                @Override
//                public void run() {
//                    long result = test.get();
//                    System.out.println("C###get:"+result);
//                }
//            }.run();
//        }


//        ThreadPool.getInstance().getThreadPoolExecutor().execute(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        VolatileTest test = new VolatileTest();
//                        test.getAndIncrement();
//                        System.out.println("A###increment");
//                        long result = test.get();
//                        System.out.println("A###:"+result);
//                    }
//                }
//        );
//
//
//        ThreadPool.getInstance().getThreadPoolExecutor().execute(
//            new Runnable() {
//                @Override
//                public void run() {
//                    VolatileTest test = new VolatileTest();
//                    long result = test.get();
//                    System.out.println("B###:"+result);
//                }
//            }
//        );
//
//        ThreadPool.getInstance().getThreadPoolExecutor().execute(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        VolatileTest test = new VolatileTest();
//                        long result = test.get();
//                        System.out.println("C###:"+result);
//                    }
//                }
//        );

//        long result = test.get();
//        System.out.println("Main###:"+result);
        final VolatileExampleTest example = getBean();
        Thread.sleep(1000);
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.read();
            }
        });
        thread2.start();
        thread2.join();


        Thread.sleep(5000);
    }

}
