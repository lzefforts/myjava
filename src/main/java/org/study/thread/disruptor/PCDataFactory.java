package org.study.thread.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 *
 * @author ArnoldLee
 * @date 18/3/1
 */
public class PCDataFactory implements EventFactory<PCData> {
    @Override
    public PCData newInstance() {
        return new PCData();
    }
}
