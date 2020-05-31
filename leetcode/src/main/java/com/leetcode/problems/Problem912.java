package com.leetcode.problems;

/**
 * 排序算法
 * 冒泡，插入，快速排序
 * Created by apa7 on 2020/5/24.
 */
public class Problem912 {

    public int[] sortArray(int[] nums) {
        quilk(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 冒泡排序
     */
    public int[] mp(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 插入排序
     * 移动位置, 逐个往前比较, 如果当前比较数较小,将它往右移
     */
    public int[] insert(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int k = i;
            while (k > 0 && temp < nums[k - 1]) {
                nums[k] = nums[k - 1];
                k--;
            }
            nums[k] = temp;
        }
        return nums;
    }

    /**
     * 选择排序
     * 选出最小，并交换
     */
    public int[] select(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 快速排序  80%
     * 1.选最左边为基准basic=nums[left]。
     * 目标：将所有大于基准的数放到右边，所有小于基准的数放到左边。
     * 2.左下标left 向右移动，一旦大于基准值，停止移动，交换左右下标对应的值.
     * 3.右下标right向左移动，一旦小于基准值，停止移动，交换左右下标对应的值.
     * 2,3移动过程中，一旦左右两个下标重合，说明目标达成，nums[left] = basic。
     *
     * @param nums 数组
     * @param L    左下标
     * @param R    右下标
     * @return
     */
    public void quilk(int[] nums, int L, int R) {
        if (L >= R) {
            return;
        }
        int left = L;
        int right = R;
        //选最左边为基准
        int val = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= val) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
            }
            while (left < right && nums[left] <= val) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
            }

            if (left >= right) {
                nums[left] = val;
            }
        }
        quilk(nums, L, left - 1);
        quilk(nums, left + 1, R);
    }

    public static void main(String[] args) {
        int v = Double.valueOf(Math.pow(10, 9)).intValue() + 7;
        System.out.println(v);
        int[] arr = {5, 1, 5, 6, 4, 9, 2, 7, 3, 1};
        Problem912 p = new Problem912();
        int[] sortArray = p.sortArray(arr);
        System.out.println(sortArray);
    }




}