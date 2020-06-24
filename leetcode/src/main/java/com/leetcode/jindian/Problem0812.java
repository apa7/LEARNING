package com.leetcode.jindian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 08.12. 八皇后
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * <p>
 * 注意：本题相对原题做了扩展
 * <p>
 * 示例:
 * <p>
 * 输入：4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by apa7 on 2020/6/24.
 */
public class Problem0812 {


    List<List<String>> res = new ArrayList<>();
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        //先按照从([0,0]-[n-1,n-1])对角线来排列
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        boolean[] vertical = new boolean[n];//垂直
        boolean[] dg = new boolean[n + n];    //正对角‘\’,row=col,满足条件为col-row相等, 譬如grid[0][0],grid[1][1]
        boolean[] udg = new boolean[n + n];   //斜对角‘/’,row=n-col,满足条件为row+col=n, 譬如grid[0][4],grid[4][0]
        dfs(0, grid, vertical, dg, udg);
        return res;
    }

    private void dfs(int row, char[][] grid, boolean[] vertical, boolean[] dg, boolean[] udg) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                list.add(new String(grid[i]));
            }
            res.add(list);
        }
        for (int col = 0; col < n; col++) {
            if (!vertical[col] && !dg[n - row + col] && !udg[row + col]) {
                grid[row][col] = 'Q';
                vertical[col] = dg[n - row + col] = udg[row + col] = true;
                dfs(row + 1, grid, vertical, dg, udg);
                grid[row][col] = '.';
                vertical[col] = dg[n - row + col] = udg[row + col] = false;
            }
        }
    }

    public static void main(String[] args) {
        Problem0812 p = new Problem0812();
        List<List<String>> r = p.solveNQueens(5);
        System.out.println(r);
    }
}