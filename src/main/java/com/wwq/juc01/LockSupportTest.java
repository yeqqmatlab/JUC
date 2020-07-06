package com.wwq.juc01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: wwq
 * @Date: 2020/6/28 12:09
 * @Description:
 */
public class LockSupportTest {

   public static class Mythread extends Thread{
       @Override
       public void run() {
           System.out.println(this.getName()+"进入线程");
           //线程阻塞
           LockSupport.park();
           System.out.println("t1线程运行结束");
       }
   }

    public static void main(String[] args) {
        Mythread t1 = new Mythread();
        t1.start();
        System.out.println("t1已经启动，但内部进行了阻塞");
        LockSupport.unpark(t1);
        System.out.println("主线程结束!");

    }
}
