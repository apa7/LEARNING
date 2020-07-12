package com.leetcode.problems.util;

import java.util.Arrays;

/**
 * Created by apa7 on 2020/6/28.
 */
public class ArrayUtil {

    public static int[] convert(String str) {
        String[] split = str.substring(1, str.length() - 1).split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.valueOf(split[i].trim());
        }
        return arr;
    }

    //{{3, 4}, {1, 5}, {4, 2}, {2, 5}, {4, 5}, {1, 2}, {1, 4}, {3, 1}, {3, 2}, {3, 5}}
    //{{3, 4}, {1, 5}, {4, 2}, {2, 5}, {4, 5}, {1, 2}, {1, 4}, {3, 1}, {3, 2}, {3, 5}}
    public static int[][] convert2(String str) {
        String[] splits = str.substring(2, str.length() - 2).split(",");
        //TODO

        int[][] arr = new int[2][2];
        return arr;
    }
}