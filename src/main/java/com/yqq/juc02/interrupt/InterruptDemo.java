package com.yqq.juc02.interrupt;

/**
 * created by yqq 2020/7/7
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        AThread aThread = new AThread();
        aThread.start();
        Thread.sleep(1); //暂停1毫秒
        /**
         * interrupt() 方法仅仅是向aThread线程发出"中断请求",至于aThread线程是否能立即响应，要看具体代码。而aThread线程在代码while循环会检测isInterrupted（）
         * 所以上述代码能正确响应interrupt（）请求,使得自身立即结束运行run()方法
         */
        aThread.interrupt();//中断aThread线程
        Thread.State state = aThread.getState();
        //aThread.join();  //等待aThread结束 才去执行主线程
        System.out.println("end");
    }
}

class AThread extends Thread{
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()){
            n ++;
            System.out.println(n + "--->");
        }
    }
}
