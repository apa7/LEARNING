package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by apa7 on 2020/6/21.
 */
public class Problem22 {

    final String open = "(";
    final String close = ")";
    List<String> list = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return list;
    }

    public void dfs(int left, int right, String str) {
        if (left == 0 && right == 0) { //满足条件左右括号都不剩余了，递归终止。
            list.add(str);
            return;
        }
        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, str + open);
        }
        if (right > left) {// 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, str + close);
        }
    }

    public static void main(String[] args) {

    }
}