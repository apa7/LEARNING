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
        Arrays.sort(arr);
        int avg = target / arr.length;
        int leftSum = 0;
        int leftIdx = 0;
        //确定左边索引
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= avg) {
                leftIdx = i;
                break;
            }
            leftSum += arr[i];
        }
        //确定右边索引
        int rightIdx = leftIdx;
        for (int i = rightIdx; i < arr.length; i++) {
            int subresult = leftSum + (arr.length - i) * arr[i] - target;
            if (subresult < 0) {
                rightIdx = i;
            } else if (subresult > 0) {
                break;
            } else {
                //结果为0,最小,直接返回
                return arr[rightIdx];
            }
        }
        //结果一定就在[arr[leftIdx], arr[rightIdx]]之间
        int left = arr[leftIdx] > avg ? avg : arr[leftIdx];
        int right = arr[rightIdx];
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (i > arr[leftIdx]) {
                leftSum += arr[leftIdx];
                leftIdx++;
            }
            int subresult = Math.abs(leftSum + (arr.length - leftIdx) * i - target);
            if (subresult < min) {
                min = subresult;
                left = i;
            } else if (subresult > min) {
                break;
            } else {
                //结果为0,最小,直接返回
                return left;
            }
        }
        return left;
    }

    public int sum(int[] arr, int mid) {
        int sum = 0;
        for (int v : arr) {
            sum += Math.min(mid, v);
        }
        return sum;
    }

    public static void main(String[] args) {
    }

}