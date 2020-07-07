package com.yqq.juc02.interrupt;

/**
 * created by yqq 2020/7/7
 */
public class InterruptDemo2 {
    public static void main(String[] args) throws InterruptedException {

        /**
         * main线程通过调用t.interrupt()从而通知t线程中断，而此时t线程正位于hello.join()的等待中，
         * 此方法会立刻结束等待并抛出InterruptedException。由于我们在t线程中捕获了InterruptedException，
         * 因此，就可以准备结束该线程。在t线程结束前，对hello线程也进行了interrupt()调用通知其中断。
         * 如果去掉这一行代码，可以发现hello线程仍然会继续运行，且JVM不会退出。
         */
        BThread bThread = new BThread();
        bThread.start();
        Thread.sleep(1000);
        bThread.interrupt();
        bThread.join();
        System.out.println("end");


    }
}

/**
 * B线程
 */
class BThread extends Thread{

    @Override
    public void run() {
        CThread cThread = new CThread();
        cThread.start();
        try {
            cThread.join();
        } catch (InterruptedException e) {
            System.out.println("interrupt");
        }
        cThread.interrupt();
    }
}

/**
 * C线程
 */
class CThread extends Thread{

    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + "--->");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }

        }
    }
}
