package com.wwq.juc01;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 11:57
 * @Description:
 */
public class CyclicBarrierDemo {

    static CyclicBarrier barrier = new CyclicBarrier(20,()-> System.out.println("20人已到"));

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {

            new Thread(()->{
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
