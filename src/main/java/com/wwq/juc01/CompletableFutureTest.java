package com.wwq.juc01;



import java.util.concurrent.CompletableFuture;

/**
 * created by yqq 2020/7/6
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureTest::fetchPrice);


        //如果执行成功
        cf.thenAccept(price -> System.out.println(price));

        //如果执行异常
        cf.exceptionally(e -> {
            e.printStackTrace();
            return null;
        });

        //主线程不要立即结束，否则CompletableFuture默认使用的线程池会立即关闭
        Thread.sleep(200);


    }

    static Double fetchPrice(){
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5+Math.random()*20;
    }
}
