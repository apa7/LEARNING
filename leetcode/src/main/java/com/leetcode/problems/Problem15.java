package com.leetcode.problems;

import java.util.*;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * Created by apa7 on 2020/6/2.
 */
public class Problem15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                //重复，跳过
                continue;
            }
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    //和为0，得到结果
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //跳过重复
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                }
                if (sum < 0) {
                    //和<0, 说明左边较小, 左指针右移
                    l++;
                } else {
                    //和>0, 说明右边较大, 右指针左移
                    r--;
                }
            }
        }
        return list;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int numi = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int numj = nums[j];
                if (map.containsKey(numj)) {
                    HashMap<Integer, Integer> integerHashMap = map.get(numj);
                    for (Map.Entry<Integer, Integer> entry : integerHashMap.entrySet()) {
                        if (entry.getKey() == numi || entry.getValue() == numj) {
                            continue;
                        }
                        list.add(new ArrayList<Integer>() {{
                            add(entry.getKey());
                            add(entry.getValue());
                            add(numj);
                        }});
                    }
                }
                int expectVal = -numi - numj;
                if (!map.containsKey(expectVal)) {
                    map.put(expectVal, new HashMap<Integer, Integer>() {{
                        put(numi, numj);
                    }});
                } else {
                    map.get(expectVal).put(numi, numj);
                }
            }
        }
        return list;
    }


    public List<List<Integer>> threeSum1(int[] nums) {
        int zeroIndex = quilkAndGetZeroIndex(nums, 0, nums.length - 1);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == 0) {
            }
        }
        return result;
    }


    public int quilkAndGetZeroIndex(int[] nums, int L, int R) {
        int zeroAtIdx = -1;
        if (L >= R) {
            zeroAtIdx = nums[L] == 0 ? L : -1;
            return zeroAtIdx;
        }
        int left = L;
        int right = R;
        int base = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= base) {
                if (nums[right] == 0) {
                    zeroAtIdx = right;
                }
                right--;
            }
            if (left <= right) {
                nums[left] = nums[right];
            }
            while (left < right && nums[left] <= base) {
                if (nums[left] == 0) {
                    zeroAtIdx = left;
                }
                left++;
            }
            if (nums[left] == 0) {
                zeroAtIdx = left;
            }
            if (nums[right] == 0) {
                zeroAtIdx = right;
            }
            if (left <= right) {
                nums[right] = nums[left];
            }
            if (left >= right) {
                nums[left] = base;
            }
        }
        quilkAndGetZeroIndex(nums, L, left - 1);
        quilkAndGetZeroIndex(nums, left + 1, R);
        return zeroAtIdx;
    }

    public static void main(String[] args) {
        Problem15 p = new Problem15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int v = p.quilkAndGetZeroIndex(nums, 0, 5);
        List<List<Integer>> lists = p.threeSum(nums);
        System.out.println(lists);
    }

}