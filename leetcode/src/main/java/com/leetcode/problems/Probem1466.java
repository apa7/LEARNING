package com.leetcode.problems;

import com.leetcode.jzoffer.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 1466. 重新规划路线
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * <p>
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 * <p>
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 * <p>
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 * <p>
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * 输出：2
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 3：
 * <p>
 * 输入：n = 3, connections = [[1,0],[2,0]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 * Created by apa7 on 2020/6/20.
 */
public class Probem1466 {

    class Solution {
        public int minReorder(int n, int[][] connections) {
            Map<Integer, List<int[]>> map = new HashMap<>(connections.length);
            for (int[] connection : connections) {
                if (map.containsKey(connection[0])) {
                    map.get(connection[0]).add(connection);
                } else {
                    ArrayList<int[]> list = new ArrayList<int[]>() {{
                        add(connection);
                    }};
                    map.put(connection[0], list);
                }
                if (map.containsKey(connection[1])) {
                    map.get(connection[1]).add(connection);
                } else {
                    ArrayList<int[]> list = new ArrayList<int[]>() {{
                        add(connection);
                    }};
                    map.put(connection[1], list);
                }
            }
            Set<Integer> historySet = new HashSet<>(connections.length);
            historySet.add(0);
            Set<Integer> parent = new HashSet<Integer>();
            parent.add(0);
            int res = 0;
            while (!parent.isEmpty()) {
                Set<Integer> tempSet = new HashSet<Integer>();
                for (Integer p : parent) {
                    List<int[]> children = map.get(p);
                    for (int[] connection : children) {
                        if (connection[0] == p && !historySet.contains(connection[1])) {
                            //逆方向[0,1]
                            res++;
                            tempSet.add(connection[1]);
                            historySet.add(connection[1]);
                        } else if (connection[1] == p && !historySet.contains(connection[0])) {
                            //顺方向[1,0]
                            tempSet.add(connection[0]);
                            historySet.add(connection[0]);
                        }
                    }
                }
                parent = new HashSet<>(tempSet);
            }
            return res;
        }

    }

    public void test() {
        Solution s = new Solution();
        int r = s.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}});
        System.out.println(r);
    }

    public static void main(String[] args) {
        Probem1466 p = new Probem1466();
        p.test();
    }
}
