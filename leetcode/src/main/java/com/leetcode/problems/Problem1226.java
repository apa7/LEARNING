package com.leetcode.problems;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 哲学家进餐问题
 * Created by apa7 on 2020/6/3.
 */
public class Problem1226 {

    class DiningPhilosophers {

        private ReentrantLock lock = new ReentrantLock();
        public DiningPhilosophers() {

        }
        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            lock.lock();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            lock.unlock();
        }
    }


}