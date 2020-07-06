package com.wwq.juc01.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 11:12
 * @Description:
 */
public class MyLock implements Lock {

    private MyAQS myAQS = new MyAQS();
    @Override
    public void lock() {
        myAQS.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        myAQS.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
