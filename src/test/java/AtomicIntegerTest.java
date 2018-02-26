import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试AtomicInteger类的方法
 * Created by ArnoldLee on 18/2/18.
 */
public class AtomicIntegerTest {

    private Logger logger = LoggerFactory.getLogger(AtomicIntegerTest.class);

    @Test
    public void testAll() throws InterruptedException {
        final AtomicInteger value = new AtomicInteger(10);
        Assert.assertEquals(value.compareAndSet(1,2),false);//如果value的值等于1,则把value的值设置为2,否则返回false
        Assert.assertEquals(value.get(),10);//比较当前值 是否是 10
        Assert.assertTrue(value.compareAndSet(10,3));
        Assert.assertEquals(value.get(),3);
        value.set(0);

        Assert.assertEquals(value.incrementAndGet(),1);
        Assert.assertEquals(value.getAndAdd(2),1);
        Assert.assertEquals(value.getAndSet(5),3);//以原子方式设置为新值,并返回旧值
        Assert.assertEquals(value.get(),5);

        final int threadSize = 10;
        Thread[] threads = new Thread[threadSize];
        for(int i=0;i<threadSize;i++){
            threads[i]=new Thread(){
               public void run(){
                   value.incrementAndGet();
               }
            };
        }

        for(Thread thread:threads){
            thread.start();
        }

        for(Thread thread:threads){
            thread.join();
        }

        Assert.assertEquals(value.get(),5+threadSize);
        logger.info("#########value:{}",value.get());



    }
}
