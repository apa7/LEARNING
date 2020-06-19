package com.leetcode.jzoffer;

/**
 * Created by apa7 on 2020/6/18.
 */
public class Problem42 {

    public int maxSubArray(int[] nums) {
        int[] sum = nums;
        for(int i=1;i<nums.length;i++){
            sum[i] = Math.max(sum[i-1], sum[i-1] + nums[i]);
            //nums[i] = Math.min(sum[i-1], sum[i-1] + nums[i]);
        }
        return sum[nums.length-1];
    }

    public static void main(String[] args) {
        Problem42 p = new Problem42();
        int i = p.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
}
