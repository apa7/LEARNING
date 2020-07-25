package com.leetcode.week;

import java.util.*;

/**
 * Created by apa7 on 2020/6/13.
 */
public class ProblemWeek20200614 {

    public int[] runningSum(int[] nums) {
        int[] dp = nums;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i] + dp[i - 1];
        }
        return dp;
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Integer value : map.values()) {
            list.add(value);
        }
        Collections.sort(list);
        int count = 0;
        int sum = 0;
        for (Integer value : list) {
            sum += value;
            if (sum > k) {
                break;
            } else {
                count++;
            }
        }
        return list.size() - count;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int left = 1, right = 1000000001;
        while (left < right) {
            int mid = (left + right) / 2;
            if (minDays(mid, k, bloomDay) < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right == 1000000001 ? -1 : right;
    }

    private int minDays(int v, int k, int[] bloomDay) {
        int count = 0, curr = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= v) {
                curr++;
                if (curr == k) {
                    curr = 0;
                    count++;
                }
            } else {
                curr = 0;
            }
        }
        return count;
    }

    public void test() {
    }

    public static void main(String[] args) {
        ProblemWeek20200614 p = new ProblemWeek20200614();
//        int[] r = p.runningSum(new int[]{1, 2, 3, 4});
//        int r = p.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1);
//        [7,7,7,7,12,7,7]
//        2
//        3
        int r = p.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3);
        System.out.println(r);
    }
}
