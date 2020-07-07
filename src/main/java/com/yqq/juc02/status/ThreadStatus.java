package com.yqq.juc02.status;

/**
 * created by yqq 2020/7/7
 */
public class ThreadStatus {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        t.start();
        /**
         * 在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算,
         * 主线程往往将于子线程之前结束，但是如果主线程处理完其他的事务后，需要用到子线程的处理结果，
         * 也就是 主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了。
         */
        t.join();
        System.out.println("end");
    }
}
