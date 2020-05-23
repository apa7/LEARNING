package com.leetcode.review;

import java.util.concurrent.CountDownLatch;

/**
 * Created by apa7 on 2020/5/14.
 */
public class CountDownLatchReview {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread() {
            @Override
            public void run() {
                System.out.println("子线程正在执行" + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                super.run();
                System.out.println("子线程正在执行完毕" + Thread.currentThread().getName());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("子线程正在执行" + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                super.run();
                System.out.println("子线程执行完毕" + Thread.currentThread().getName());
            }
        }.start();
        System.out.println("等待2个子线程执行完毕");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2个子线程执行完毕");

//        StampedLock
//        Semaphore
//        FutureTask
//        ThreadLocalMap
    }

}