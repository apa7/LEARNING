package com.leetcode.problems;

/**
 * Created by apa7 on 2020/5/27.
 */
public class HllProblem {


    public int getWay(int[][] arr) {
        int[] row = new int[2];
        int[] col = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    row[0] = i;
                    col[0] = j;
                }
                if (arr[i][j] == 2) {
                    row[1] = i;
                    col[1] = j;
                }
            }
        }
        int a = row[1] > row[0] ? 1 << 1 : 0 << 1;
        int b = col[1] > col[0] ? 1 : 0;
        return dfs(arr, row[0], col[0], a | b);
    }

    /**
     * state
     * 00    上左
     * 01    上右
     * 10    下左
     * 11    下右
     */
    public int dfs(int[][] arr, int currentRow, int currentCol, int state) {
        if (currentRow < 0 || currentRow >= arr.length || currentCol < 0 || currentCol >= arr[0].length || arr[currentRow][currentCol] == -1) {
            return 0;
        }
        if (arr[currentRow][currentCol] == 2) {
            return 1;
        }
        return ((state & 1) == 1 ? dfs(arr, currentRow, currentCol + 1, state) : dfs(arr, currentRow, currentCol - 1, state))
               +
               ((state & 3) == 3 ? dfs(arr, currentRow + 1, currentCol, state) : dfs(arr, currentRow - 1, currentCol, state));
    }



    public static void main(String[] args) {
        HllProblem p = new HllProblem();
        int[][] arr = new int[3][3];
        arr[0] = new int[]{0, 0, 1};
        arr[1] = new int[]{0, 0, 0};
        arr[2] = new int[]{2, 0, 0};
        int way = p.getWay(arr);
        System.out.println(way);
    }

}