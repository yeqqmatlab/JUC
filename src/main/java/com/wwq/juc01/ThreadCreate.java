package com.wwq.juc01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 10:15
 * @Description:
 */
public class ThreadCreate {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();



        CompletableFuture.runAsync(()-> System.out.println("Hello"));

        System.out.println( ForkJoinPool.commonPool().getPoolSize());
    }
}
