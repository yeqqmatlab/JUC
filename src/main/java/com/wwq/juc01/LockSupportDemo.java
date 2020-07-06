package com.wwq.juc01;
import	java.util.concurrent.TimeUnit;

import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 12:09
 * @Description:
 */
public class LockSupportDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("子线程执行");
            LockSupport.park();
            System.out.println("子线程执行结束");
        });
        thread.start();

        TimeUnit.SECONDS.sleep(10);
        LockSupport.unpark(thread);

    }
}
