package com.leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by apa7 on 2020/6/21.
 */
public class Problem20 {

    public boolean isValid(String s) {
        char[] close = new char[128];
        close['('] = ')';
        close['{'] = '}';
        close['['] = ']';
        close[')'] = '/';
        close['}'] = '/';
        close[']'] = '/';
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (close[c] == '/') {
                //闭
                if (list.isEmpty() || close[list.pop()] != c) {
                    return false;
                }
            } else {
                //开
                list.push(c);
            }
        }
        return list.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = new Problem20().isValid("([)]");
        System.out.println(valid);
    }
}
