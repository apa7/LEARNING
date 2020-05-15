package com.leetcode.jzoffer;

import java.util.LinkedList;

/**
 * 面试题13. 机器人的运动范围
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * Created by apa7 on 2020/5/14.
 * 深度搜索(fds)
 */
public class Problem13 {

    public int movingCount(int m, int n, int k) {
        //return dfs(new boolean[m][n], 0, 0, k);
        return bfs(new boolean[m][n], k);
    }

    /**
     * 深度优先搜索
     *
     * @param arr 路径
     * @param i   行
     * @param j   列
     * @param k   k
     * @return result
     */
    public int dfs(boolean[][] arr, int i, int j, int k) {
        if (i < 0 || i > arr.length - 1 || j < 0 || j > arr[0].length - 1) {
            //索引越界
            return 0;
        }
        if (arr[i][j] || sumDigit(i) + sumDigit(j) > k) {
            return 0;
        }
        arr[i][j] = true;
        return 1 +
               dfs(arr, i, j + 1, k) +  //向右
               dfs(arr, i + 1, j, k);   //向下
    }

    /**
     * 广度优先搜索
     *
     * @param arr
     * @param k   k
     * @return result
     */
    private int bfs(boolean[][] arr, int k) {
        LinkedList<int[]> queue = new LinkedList<int[]>();
        queue.push(new int[]{0, 0});
        int count = 0;
        while (!queue.isEmpty()) {
            int[] data = queue.pop();
            int i = data[0];
            int j = data[1];
            if (i < 0 || i > arr.length - 1 || j < 0 || j > arr[0].length - 1) {
                //索引越界
                continue;
            }
            if (arr[i][j] || sumDigit(i) + sumDigit(j) > k) {
                continue;
            }
            arr[i][j] = true;
            count++;
            queue.push(new int[]{i + 1, j});
            queue.push(new int[]{i, j + 1});
        }
        return count;
    }

    /**
     * 各位数值相加
     *
     * @param v 数
     * @return 和
     */
    public int sumDigit(int v) {
        int n = 0;
        while (v != 0) {
            n += v % 10;
            v /= 10;
        }
        return n;
    }

    public static void main(String[] args) {
        Problem13 p = new Problem13();
        int count = p.movingCount(4, 5, 5);
        System.out.println(count);
/*        int i = p.sumDigit(10);
        System.out.println(i);*/
    }

}