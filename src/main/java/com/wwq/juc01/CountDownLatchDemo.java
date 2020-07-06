package com.wwq.juc01;
import	java.util.concurrent.CompletableFuture;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 11:48
 * @Description:
 */
public class CountDownLatchDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(4);

    public static void main(String[] args) throws InterruptedException {
        for (int i= 0; i< 6; i++){
            CompletableFuture.runAsync(()->{
                System.out.println("thread-->"+Thread.currentThread().getName());
                try {
                    //等待10毫秒
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("main thread ");
    }
}
