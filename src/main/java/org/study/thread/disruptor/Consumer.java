package org.study.thread.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * 消费者
 * @author ArnoldLee
 * @date 18/2/28
 */
public class Consumer implements WorkHandler<PCData> {
    @Override
    public void onEvent(PCData pcData) throws Exception {
        System.out.println(Thread.currentThread().getId()+":Event:--"+pcData.getIntData()*pcData.getIntData()+"--");
    }
}
