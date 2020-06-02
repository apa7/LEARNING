package com.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by apa7 on 2020/6/1.
 */
public class Problem239 {

    /**
     * 单调栈
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length < k || k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        //last->first单调增长，为了方便计算窗口区间，这里存放数组下标。
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(0);
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            //超出窗口区间，淘汰
            while (!list.isEmpty() && list.peekFirst() < (i - k + 1)) {
                list.removeFirst();
            }
            //如果上一步淘汰干净了，从窗口最前面开始重新生成单调栈
            if (list.isEmpty() && (i - k + 1) > 0) {
                list.addFirst(i - k + 1);
                for (int j = i - k + 2; j < i; j++) {
                    if (nums[j] >= nums[list.peekFirst()]) {
                        list.addFirst(j);
                    }
                }
            }
            //加入单调栈
            if (val >= nums[list.peekFirst()]) {
                list.addFirst(i);
            }
            //最大值的就在first
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[list.peekFirst()];
            }
        }
        return result;
    }

    /**
     * dp
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int maxIdx = -1;
        int max = Integer.MIN_VALUE;
        for (int start = 0; start < result.length; start++) {
            if (maxIdx < start) {
                max = nums[start];
                for (int j = start + 1; j <= start + k - 1; j++) {
                    if (max <= nums[j]) {
                        max = nums[j];
                        maxIdx = j;
                    }
                }
            } else {
                int end = start + k - 1;
                if (max <= nums[end]) {
                    max = nums[end];
                    maxIdx = end;
                }
            }
            result[start] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem239 p = new Problem239();
        int[] result = p.maxSlidingWindow(new int[]{1, -9, 8, -6, 6, 4, 0, 5}, 4);
        System.out.println(Arrays.toString(result));
    }

}