package com.wwq.juc01.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 12:48
 * @Description:
 */
public class FactoryDemo implements EventFactory<LongEvent> {
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
