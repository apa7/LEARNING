package com.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 378. 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 * Created by apa7 on 2020/7/2.
 */
public class Problem378 {

    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 1) return matrix[0][k-1];
        int[] arr = new int[matrix.length*matrix.length];
        int idx = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                arr[idx++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }

    public static void main(String[] args) {
        Problem378 p = new Problem378();
        int r = p.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8);
        System.out.println(r);
    }

}