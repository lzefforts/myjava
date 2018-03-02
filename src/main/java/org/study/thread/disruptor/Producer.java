package org.study.thread.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * 生产者
 * @author ArnoldLee
 * @date 18/3/1
 */
public class Producer {

    private final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb){
        long sequence = ringBuffer.next();
        try {
            PCData event = ringBuffer.get(sequence);
            System.out.println("bb.getLong(0):"+bb.getLong(0));
            event.setIntData(bb.getLong(0));

        }finally {
            ringBuffer.publish(sequence);
        }



    }


}
