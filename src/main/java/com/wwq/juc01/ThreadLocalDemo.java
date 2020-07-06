package com.wwq.juc01;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 12:32
 * @Description:
 */
public class ThreadLocalDemo {
    static ThreadLocal<String> threadLocal =new ThreadLocal<String> ();

    public static void main(String[] args) {
        for(int i=0; i<10; i++) {

            new Thread(()->{
                try {
                    threadLocal.set(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(10);

                    System.out.println(threadLocal.get()+"--"+Thread.currentThread().getName());
                    threadLocal.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }

        //while (true);
    }
}
