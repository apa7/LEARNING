package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apa7 on 2020/7/12.
 */
public class Problem5460 {

    double[] probs;
    Map<Integer, List<Node>> map;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        probs = new double[n];
        map = new HashMap<>(n);
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) {
                List<Node> list = new ArrayList<>();
                list.add(new Node(i, edges[i][1], succProb[i]));
                map.put(edges[i][0], list);
            } else {
                map.get(edges[i][0]).add(new Node(i, edges[i][1], succProb[i]));
            }
        }
        return pro(1, start, end);
    }

    public double pro(double val, int start, int end) {
        if (start == end) {
            return 1;
        }
        if (!map.containsKey(start)) {
            return 0;
        }
        List<Node> nodes = map.get(start);
        for (Node node : nodes) {
            pro(val * node.prob, node.val, end);

        }
        return 0.0;//TODO
    }

    class TreeNode {
        int index;
        int val;
        double prob;
//        List<TreeNode> children = new TreeNode();

    }

    class Node implements Comparable<Node> {
        int index;
        int val;
        double prob;

        public Node(int index, int val, double prob) {
            this.index = index;
            this.val = val;
            this.prob = prob;
        }

        @Override
        public int compareTo(Node o) {
            return this.prob > o.prob ? 1 : -1;
        }
    }


    class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    double delta = 0.99;//温度下降速度

    int dx[] = new int[]{0, 0, -1, 1};
    int dy[] = new int[]{-1, 1, 0, 0};  //上下左右四个方向

    double dist(Point A, Point B) {
        return Math.sqrt((A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y));
    }

    double cross(Point A, Point B, Point C) {
        return (B.x - A.x) * (C.y - A.y) - (B.y - A.y) * (C.x - A.x);
    }

    double multi(Point A, Point B, Point C) {
        return (B.x - A.x) * (C.x - A.x) + (B.y - A.y) * (C.y - A.y);
    }

    double getSum(Point p[], Point t) {
        double ans = 0;
        for (Point point : p) {
            ans += dist(point, t);
        }
        return ans;
    }

    double search(Point p[]) {
        Point s = p[0];       //随机初始化一个点开始搜索
        double t = 200;       //初始化温度
        double ans = 50 * 200;//初始化答案值
        while (t > 0.00001) { //最小搜索精度
            boolean flag = true;
            while (flag) {
                flag = false;
                for (int i = 0; i < 4; i++)    //上下左右四个方向
                {
                    Point z = new Point(s.x + dx[i] * t, s.y + dy[i] * t);
                    double tp = getSum(p, z);
                    if (ans > tp) {
                        ans = tp;
                        s = z;
                        flag = true;
                    }
                }
            }
            t *= delta;
        }
        return ans;
    }

    public double getMinDistSum(int[][] positions) {
        Point[] points = new Point[positions.length];
        int i = 0;
        for (int[] pos : positions) {
            points[i++] = new Point(pos[0], pos[1]);
        }
        return search(points);
    }

    public static void main(String[] args) {
        Problem5460 p = new Problem5460();
        double res = p.getMinDistSum(new int[][]{{0, 1}, {1, 0}, {1, 2}, {2, 1}});
        System.out.println(res);
    }
}