package com.leetcode.week;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import sun.reflect.generics.tree.Tree;

/**
 * 周赛20200719
 * 微软中国主题
 * Created by apa7 on 2020/7/19.
 */
public class Week198 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int remain = 0;
        while (numBottles + remain >= numExchange) {
            numBottles += remain;
            remain = numBottles % numExchange;
            numBottles = numBottles / numExchange;
            res += numBottles;
        }
        return res;
    }

    String lb = "";
    Map<Character, Integer> mp = new HashMap<>();

    Map<Character, Integer> go(int rt, ArrayList<Integer> g[], int fa) {
        Map<Character, Integer> tot = new HashMap<>();
        if (g[rt].size() > 0) {
            for (int to : g[rt]) {
                if (to == fa) continue;
                Map<Character, Integer> cc = go(to, g, rt);
                for (Character c : cc.keySet()) {
                    tot.put(c, tot.getOrDefault(c, 0) + cc.get(c));
                }
            }
        }
        char cur = lb.charAt(rt);
        tot.put(cur, tot.getOrDefault(cur, 0) + 1);
        ans[rt] = tot.get(cur);
        return tot;
    }

    int ans[];

    public int[] countSubTrees(int n, int[][] es, String labels) {
        lb = labels;
        ArrayList<Integer> g[] = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        for (int[] e : es) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        ans = new int[n];
        go(0, g, -1);
        return ans;

    }

    public void test() {
        //numWaterBottles(15, 4);
        int[] res = countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed");
        System.out.println(res);
    }

    public static void main(String[] args) {
        Week198 w = new Week198();
        w.test();
    }
}