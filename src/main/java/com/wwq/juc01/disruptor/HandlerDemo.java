package com.wwq.juc01.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 12:47
 * @Description:
 */
public class HandlerDemo implements EventHandler<LongEvent> {
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}
