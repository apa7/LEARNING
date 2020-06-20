package com.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by apa7 on 2020/6/20.
 */
public class Problem118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if(numRows <= 0){
            return res;
        }
        LinkedList<Integer> rowList = new LinkedList<>();
        rowList.add(1);
        res.add(rowList);
        for (int i = 1; i < numRows; i++) {
            //i层长度i+1
            LinkedList<Integer> curRowList = new LinkedList<Integer>();
            //左边res[i][0] = res[i-1][0],
            curRowList.add(rowList.getFirst());
            //中间 res[i][1]=res[i-1][0]+ res[i-1][1]
            for (int j = 1; j <= i - 1; j++) {
                curRowList.add(rowList.get(j-1) + rowList.get(j));
            }
            //右边res[i][i]=res[i-1][i-1];
            curRowList.add(rowList.getLast());
            res.add(curRowList);
            rowList = new LinkedList<>(curRowList);
        }

        return res;
    }

    public List<Integer> getRow(int rowIndex) {
        int len = rowIndex+1;
        Integer[] res = new Integer[len];
        int midIdx = rowIndex/2 + 1;
        int cur = 1;
        for(int i=0; i<midIdx; i++){
            res[i] = cur;
            res[rowIndex-i] = cur;
            cur = cur * (rowIndex-i) / (i+1);
        }
        //处理奇数行中间下标的值.
        if(rowIndex%2==1){
            res[midIdx]=cur;
        }
        return Arrays.asList(res);
    }
//   0 [1]
//  ...
//   6 [1, 7, 21, 35, 35, 21, 7, 1]
//   7 [1, 8, 28, 56, 70, 56, 28, 8, 1]
//
//头/尾->中间 1,1*9/1=9,9*8/2=36,36*7/3=84,84*6/4=126
//3  1,1*3/1=3,
//4 1,1*4/1=4

    public static void main(String[] args) {
        Problem118 p = new Problem118();
        List<List<Integer>> r = p.generate(10);
        System.out.println(r);
    }

}
