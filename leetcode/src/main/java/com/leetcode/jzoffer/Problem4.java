package com.leetcode.jzoffer;

/**
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 * <p>
 * Created by apa7 on 2020/5/11.
 */
public class Problem4 {

    /**
     * 暴力解法.
     * 时间复杂度：O(mn)  二维数组中的每个元素都被遍历，因此时间复杂度为二维数组的大小。
     * 空间复杂度：O(1)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * 线性查找解法.
     * 从右上角开始
     * 大于targer则索引-1
     * 小于targer则索引+1
     *
     * 选左上角，往右走和往下走都增大，不能选
     * 选右下角，往上走和往左走都减小，不能选
     * 选左下角，往右走增大，往上走减小，可选
     * 选右上角，往下走增大，往左走减小，可选
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int y = 0;
        int x = matrix[0].length - 1;
        while (y < matrix.length && x >= 0) {
            if (matrix[y][x] > target) {
                x--;
            } else if (matrix[y][x] < target) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] ints = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 20, 22},
                {10, 13, 14, 21, 24},
                {18, 21, 23, 22, 30}
        };
        boolean numberIn2DArray1 = new Problem4().findNumberIn2DArray1(ints, 5);
        boolean numberIn2DArray2 = new Problem4().findNumberIn2DArray2(ints, 20);
        System.out.println(numberIn2DArray1);
        System.out.println(numberIn2DArray2);
    }

}