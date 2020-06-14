package com.leetcode.problems;

import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * <p>
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * <p>
 * 请注意，答案不一定是 arr 中的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * 示例 2：
 * <p>
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 * Created by apa7 on 2020/6/14.
 */
public class Problem1300 {

    public int findBestValue(int[] arr, int target) {
        int len = arr.length;
        int avg = target / len;
        int leftSum = 0;
        int eqIdx = 0;
        Arrays.sort(arr);
        for (int num : arr) {
            if (num >= avg) {
                break;
            }
            leftSum += num;
            eqIdx++;
        }
        //左边少的，即与target的差距
        int remain = leftSum + avg * (len - eqIdx) - target;
        //从截止索引开始右移,缩小范围
        for (int i = eqIdx; i < len; i++) {
            //leftSum + arr[i] + avg
            remain += arr[i];
            if (remain > 0) {
                eqIdx = i;
                break;
            }
        }
        //TODO
        return avg;
    }


    public int findBestValue2(int[] arr, int target) {
        int n = arr.length;
        int avg = target / n;
        // 记录前一轮的差值
        int pre = Integer.MAX_VALUE;
        // 从平均值开始遍历
        for (int i = avg; ; ++i) {
            // 记录每轮的总和
            int sum = 0;
            for (int value : arr) {
                sum += Math.min(value, i);
            }
            // 比较差值，看前一个点是否是最小值
            if (Math.abs(sum - target) >= pre) {
                return i - 1;
            }
            // 更新差值记录
            pre = Math.abs(sum - target);
        }
    }


    public static void main(String[] args) {
        Problem1300 p = new Problem1300();
        p.findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803);
    }

}