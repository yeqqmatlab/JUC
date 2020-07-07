package com.yqq.juc02.interrupt;

/**
 * 线程中断
 * created by yqq 2020/7/7
 */
public class RunningDemo {
    public static void main(String[] args) throws InterruptedException {
        HelloThread t = new HelloThread();
        t.start();
        Thread.sleep(1);
        t.running = false;
        t.join();
        System.out.println("main end!");

    }
}

class HelloThread extends Thread{
    public volatile boolean running = true;

    @Override
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + "---> hello!");
        }
        System.out.println("HelloThread end!");
    }
}