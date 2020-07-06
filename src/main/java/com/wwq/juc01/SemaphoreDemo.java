package com.wwq.juc01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 12:04
 * @Description:
 */
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(2, true);

    public static void main(String[] args) {
        for (int i= 0; i< 10; i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("线程："+Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(10);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        while (true);
    }
}
