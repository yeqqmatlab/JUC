package com.wwq.juc01.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 11:15
 * @Description:
 */
public class MyAQS extends AbstractQueuedSynchronizer {
    protected MyAQS() {
        super();
    }

    @Override
    protected int tryAcquireShared(int arg) {//共享锁
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {//共享锁
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean tryAcquire(int arg) {//独占锁
        if(compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {//独占锁
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }
}
