package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apa7 on 2020/6/21.
 */
public class Problem38 {

    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 2; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            int count = 1;
            Integer pre = null;
            for (int v : list) {
                if (pre == null) {
                    pre = v;
                } else if (pre != v) {
                    temp.add(count);
                    temp.add(pre);
                    pre = v;
                    count = 1;
                } else {
                    count++;
                }
            }
            temp.add(count);
            temp.add(pre);
            list = new ArrayList<>(temp);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return sb.toString();
    }
}
