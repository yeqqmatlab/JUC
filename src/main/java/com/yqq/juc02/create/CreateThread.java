package com.yqq.juc02.create;

/**
 * 二个线程是独立的
 * 可能 [main 主线程]先打印，也可能[t线程]先打印
 * created by yqq 2020/7/7
 */
public class CreateThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> System.out.println("t线程")); //java8 lambda 写法
        t.start();
        //Thread.sleep(100);
        System.out.println("main 主线程");

    }
}
