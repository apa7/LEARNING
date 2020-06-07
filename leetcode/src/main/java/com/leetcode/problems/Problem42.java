package com.leetcode.problems;

/**
 * Created by apa7 on 2020/6/6.
 */
public class Problem42 {

    public int trap(int[] height) {
        int len = height.length;
        if (len <= 1) {
            return 0;
        }
        //代表当前位置的左边最大的值
        int[] left = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = height[i - 1] > left[i - 1] ? height[i - 1] : left[i - 1];
        }
        //代表当前位置右边的最大值
        int[] right = new int[len];
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = height[i + 1] > right[i + 1] ? height[i + 1] : right[i + 1];
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            //left[i]与right[i] 较小的 就能确定当前的接水容器高度，高度减掉当前高度就是能接雨水的值
            int h = Math.min(left[i], right[i]);
            if (h > height[i]) {
                sum += h - height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem42 p = new Problem42();
        int r = p.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(r);
    }

}