package com.leetcode.week;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by apa7 on 2020/6/21.
 */
public class ProblemWeek20200628 {

    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int x = path.length();
        int y = path.length();
        set.add(x + "," + y);
        char[] pc = path.toCharArray();
        for (int i = 0; i < pc.length; i++) {
            char c = pc[i];
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                default:
                    break;
            }
            String r = x + "," + y;
            if (set.contains(r)) {
                return true;
            } else {
                set.add(r);
            }
        }
        return false;
    }

    public boolean canArrange(int[] arr, int k) {
        int[] map = new int[k];
        for (int v : arr) {
            int mod = (v % k + k) % k;
            map[mod] = map[mod] + 1;
        }
        if (map[0] > 0 && map[0] % 2 != 0) {
            return false;
        }
        if (k % 2 == 0 && map[k / 2] > 0 && map[k / 2] % 2 != 0) {
            return false;
        }
        for (int i = 1; i < (k + 1) / 2; i++) {
            int v = map[i] + map[k - i];
            if (v % 2 == 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public int numSubseq(int[] nums, int target) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] + nums[left + 1] > target) {
            return 0;
        }
        if (nums[right] + nums[right] <= target) {
            long max = Double.valueOf(Math.pow(2, nums.length)).longValue() - 1;
            return (int) (max % 1000000007);
        }
        long res = 0;
        while (left <= right) {
            while (left <= right && nums[left] + nums[right] > target) {
                right--;
            }
            if (right < left) {
                break;
            }
            res = (res + Double.valueOf(Math.pow(2, right - left)).longValue() % 1000000007) % 1000000007;
            left++;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        ProblemWeek20200628 p = new ProblemWeek20200628();
//        [-1,1,-2,2,-3,3,-4,4]
//        3
        int r = p.numSubseq(new int[]{27, 21, 14, 2, 15, 1, 19, 8, 12, 24, 21, 8, 12, 10, 11, 30, 15, 18, 28, 14, 26, 9, 2, 24, 23, 11, 7, 12, 9, 17, 30, 9, 28, 2, 14, 22, 19, 19, 27, 6, 15, 12, 29, 2, 30, 11, 20, 30, 21, 20, 2, 22, 6, 14, 13, 19, 21, 10, 18, 30, 2, 20, 28, 22}, 31);
        System.out.println(r);
    }

//    [27,21,14,2,15,1,19,8,12,24,21,8,12,10,11,30,15,18,28,14,26,9,2,24,23,11,7,12,9,17,30,9,28,2,14,22,19,19,27,6,15,12,29,2,30,11,20,30,21,20,2,22,6,14,13,19,21,10,18,30,2,20,28,22]
//            31
//    输出：
//            -894291810
//    预期：
//            688052206


}