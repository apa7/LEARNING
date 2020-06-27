package com.leetcode.problems;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * Created by apa7 on 2020/6/27.
 */
public class Problem34 {

    public int[] searchRange(int[] nums, int target) {
        int left = search(nums, target, true);
        int right = search(nums, target, false);
        return new int[]{left, right};
    }

    public int search(int[] nums, int target, boolean searchLeft) {
        int res = -1, left=0, right=nums.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] > target) {
                right = mid-1;
            } else if(nums[mid] < target){
                left = mid+1;
            } else {
                res = mid;
                if(searchLeft){
                    right = mid-1;
                } else{
                    left = mid+1;
                }
            }
        }
        return res;
    }

}