package com.leetcode.jzoffer;

/**
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 * Created by apa7 on 2020/5/29.
 */
public class Problem29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int minRow = 0;
        int maxRow = matrix.length - 1;
        int minCol = 0;
        int maxCol = matrix[0].length - 1;
        int max = (maxRow + 1) * (maxCol + 1);
        int[] result = new int[max];
        int index = 0;
        while (index < max) {
            //右
            for (int i = minCol; i <= maxCol; i++) {
                result[index++] = matrix[minRow][i];
            }
            minRow++;
            //下
            for (int i = minRow; index < max && i <= maxRow; i++) {
                result[index++] = matrix[i][maxCol];
            }
            maxCol--;
            //左
            for (int i = maxCol; index < max && i >= minCol; i--) {
                result[index++] = matrix[maxRow][i];
            }
            maxRow--;
            //上
            for (int i = maxRow; index < max && i >= minRow; i--) {
                result[index++] = matrix[i][minCol];
            }
            minCol++;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem29 p = new Problem29();
        p.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
    }

}