package com.leetcode.problems;

/**
 * 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * Created by apa7 on 2020/6/11.
 */
public class Problem739 {

    public int[] dailyTemperatures(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        for (int i = arr.length - 1; i >= 0; i--) {
            int v = arr[i];
            for (int j = i + 1; j < len; j++) {
                if (arr[j] > v) {
                    result[i] = j - i;
                    break;
                } else if (result[j] ==0) {
                    //说明后面没有比arr[j]更大的了。
                    break;
                } else {
                    //arr[j] 比当前小，跳到arr增长位置。
                    j += result[j] - 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem739 p = new Problem739();
        p.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

}