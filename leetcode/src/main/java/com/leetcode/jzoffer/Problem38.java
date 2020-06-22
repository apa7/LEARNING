package com.leetcode.jzoffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by apa7 on 2020/6/22.
 */
public class Problem38 {

    class Solution {
        Set<String> res = new HashSet<>();
        char[] arr;

        public String[] permutation(String s) {
            arr = s.toCharArray();
            List<Integer> idxList = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                idxList.add(i);
            }
            dfs(0);
            return res.toArray(new String[res.size()]);
        }

        private void dfs(int x) {
            if (x == arr.length - 1) {
                res.add(String.valueOf(arr));
                return;
            }
            Set<Character> set = new HashSet<>();
            //这里就很巧妙了,第一层可以是a,b,c那么就有三种情况，这里i = x,正巧dfs(0)，正好i = 0开始
            // 当第二层只有两种情况，dfs(1）i = 1开始
            for (int i = x; i < arr.length; i++) {
                //重复，剪枝
                if (set.contains(arr[i])) continue;
                set.add(arr[i]);
                swap(i, x); //交换,将arr[i]固定到第x位
                dfs(x + 1); //开启固定第x+1位字符
                swap(x, i); //恢复交换
            }
        }

        private void swap(int a, int b) {
            char temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
