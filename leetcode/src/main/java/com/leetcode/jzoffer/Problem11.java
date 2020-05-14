package com.leetcode.jzoffer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 * Created by apa7 on 2020/5/13.
 */
public class Problem11 {

    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j -= 1;
            }
        }
        return numbers[i];
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        Problem11 p = new Problem11();
        int min = p.minArray(arr);
        System.out.println(min);

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        CountDownLatch cdl = new CountDownLatch(1);
        cdl.countDown();
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}