package com.wwq.juc01;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 10:30
 * @Description:
 */
public class VolatileDemo{
    /*volatile*/ boolean running = true;
    void m() {
        System.out.println("m start");
        while(running) {
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        VolatileDemo t = new VolatileDemo();

        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }
}
