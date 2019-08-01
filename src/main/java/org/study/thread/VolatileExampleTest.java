package org.study.thread;

/**
 *
 * @author ArnoldLee
 * @date 2019/5/21
 */
public class VolatileExampleTest {

    int x = 0;
//    volatile int b = 0;
    int b = 0;

    private void write() {
        x = 5;
        b = 1;
        System.out.println("write!");
    }

    public void read() {
        System.out.println("read!");
        System.out.println(b);
        if (b == 1) {
            System.out.println(x);
            System.out.println("do while...");
        }
    }

    public static void main(String[] args) throws Exception {
        final VolatileExampleTest example = new VolatileExampleTest();
        VolatileTest.setBean(example);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.write();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.read();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
//        Thread.sleep(6000);
    }


}
