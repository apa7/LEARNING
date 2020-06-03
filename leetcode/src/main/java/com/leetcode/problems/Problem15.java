package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apa7 on 2020/6/2.
 */
public class Problem15 {

    public List<List<Integer>> threeSum(int[] nums) {
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