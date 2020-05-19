package com.leetcode.review;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by apa7 on 2020/5/18.
 */
public class LockReview {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }

}
