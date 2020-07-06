package com.wwq.juc01;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 10:58
 * @Description:
 */
public class SynchronizedDemo {

     Object o = new Object();

    void m() {
        synchronized(o) {
            while(true) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());

            }
        }
    }
    public static void main(String[] args) throws IOException {
        SynchronizedDemo t = new SynchronizedDemo();
        //启动第一个线程
        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //创建第二个线程
        Thread t2 = new Thread(t::m, "t2");
        t.o = new Object();
        t2.start();
    }
}
