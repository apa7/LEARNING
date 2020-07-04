package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * 通过次数147,126提交次数192,867
 * 在真实的面试中遇到过这道题？
 * Created by apa7 on 2020/7/3.
 */

//TODO w未完成
public class Problem46 {

    private List<List<Integer>> res;
    private int len;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        len = nums.length;
        findPermute(nums, new Integer[len], 0);
        return res;
    }

    private void findPermute(int[] nums, Integer[] sub, int idx) {
        if (idx == len - 1) {
            sub[idx] = nums[idx];
            res.add(Arrays.asList(sub));
            return;
        }
        sub[idx] = nums[idx];
        findPermute(nums, sub, idx + 1);
        if (idx < len - 1) {
            swap(nums, idx, idx + 1);
            findPermute(nums, sub, idx);
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public static void main(String[] args) {
        Problem46 p = new Problem46();
        List<List<Integer>> r = p.permute(new int[]{1, 2, 3});
        System.out.println(r);
    }
}
