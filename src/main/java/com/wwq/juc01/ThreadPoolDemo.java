package com.wwq.juc01;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import	java.util.concurrent.TimeUnit;

import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.Runtime.*;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 12:18
 * @Description:
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(getRuntime().availableProcessors(),
                getRuntime().availableProcessors()* 2,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPool.execute(()-> System.out.println("threadPool"));
    }
}
