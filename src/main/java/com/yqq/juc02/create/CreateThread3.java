package com.yqq.juc02.create;

/**
 * 二个线程是独立的
 * 可能 [main 主线程]先打印，也可能[t线程]先打印
 * created by yqq 2020/7/7
 */
public class CreateThread3 {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new MyRunable());
        t.start();
        System.out.println("main thread");

    }
}

class MyRunable implements Runnable{

    @Override
    public void run() {
        System.out.println("start new thread");
    }
}
