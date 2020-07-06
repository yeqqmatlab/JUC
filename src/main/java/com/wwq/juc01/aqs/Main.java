package com.wwq.juc01.aqs;

import java.util.concurrent.CompletableFuture;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 11:19
 * @Description:
 */
public class Main {

    private static int count = 10;

    private static MyLock lock = new MyLock();

    public static void main(String[] args) {
        CompletableFuture.runAsync(()->{
            try {
                lock.lock();
                while (count >0){
                    count--;
                    System.out.println(count);
                }
            }finally {
                lock.unlock();
            }
        });

        while (true);
    }
}
