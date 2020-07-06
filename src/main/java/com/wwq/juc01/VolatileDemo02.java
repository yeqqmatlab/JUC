package com.wwq.juc01;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 10:44
 * @Description:
 */
public class VolatileDemo02 {
    static  int x,y,m,n;//测试用的变量

    public static void main(String[] args) throws InterruptedException {

        while (true){
             CountDownLatch countDownLatch = new CountDownLatch(2);
            x=y=m=n=0;
            //线程一
            Thread one = new Thread(() -> {
                m=1;
                x=n;
                countDownLatch.countDown();
            });
            //线程二
            Thread two = new Thread(() -> {
                n=1;
                y=m;
                countDownLatch.countDown();
            });
            //启动并等待线程执行结束
            one.start();
            two.start();
            one.join();
            two.join();
            //输出结果
            countDownLatch.await();
           if (x==0 && y ==0){
               System.out.println("x:"+x+",y:"+y);
               //break;
           }
        }
    }
}
