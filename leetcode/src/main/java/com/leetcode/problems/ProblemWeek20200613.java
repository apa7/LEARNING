package com.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by apa7 on 2020/6/13.
 */
public class ProblemWeek20200613 {

    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack();
        stack.push(prices[prices.length - 1]);
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] >= stack.peek()) {
                Integer temp = stack.peek();
                stack.push(prices[i]);
                prices[i] -= temp;
            } else {
                //stack.pop();
                while (stack.size() != 0 && prices[i] < stack.peek()) {
                    stack.pop();
                }
                int temp = prices[i];
                if (stack.size() != 0) {
                    prices[i] -= stack.peek();
                }
                stack.push(temp);
            }
        }
        return prices;
    }

    public static int minSumOfLengths(int[] arr, int target) {
        if (arr == null || arr.length <= 2) {
            return -1;
        }
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        return -1;
    }

    class SubrectangleQueries {

        private volatile int[][] rec;

        public SubrectangleQueries(int[][] rectangle) {
            rec = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    rec[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return rec[row][col];
        }
    }

    class Solution {
        public int minSumOfLengths(int[] arr, int target) {

            int minLen = Integer.MAX_VALUE;
            int secondLen = Integer.MAX_VALUE;
            int minRight = 0;

            int[] preSum = new int[arr.length + 1];
            Map<Integer, Integer> map = new HashMap<>();
            preSum[0] = 0;
            map.put(preSum[0], 0);

            for(int k=0; k<arr.length; k++) {
                preSum[k+1] = preSum[k] + arr[k];
                map.put(preSum[k+1], k+1);
            }

            for(int l=1; l<arr.length+1; l++) {
                int tmp = preSum[l] - target;
                if(map.containsKey(tmp)) {
                    int calLen = Math.abs(map.get(tmp) - l) ;

                    if(calLen < minLen) {
                        secondLen = minLen;
                        minRight = l;
                        minLen = calLen;
                    } else if(calLen < secondLen && map.get(tmp) >= minRight) {
                        secondLen = calLen;
                    }
                }
            }

            if(minLen == Integer.MAX_VALUE || secondLen == Integer.MAX_VALUE) return -1;
            return minLen + secondLen;
        }
    }

    public void test() {
//        ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
//[[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
//        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(new int[][]{{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}});
//        subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
//        [1,2,2,3,2,6,7,2,1,4,8]
//        5
        int r = new Solution().minSumOfLengths(new int[]{1, 2, 2, 3, 2, 6, 7, 2, 1, 4, 8}, 5);
        System.out.println(r);
    }

    public static void main(String[] args) {
        /*int[] r = {8, 4, 6, 2, 3};
        int[] r1 = finalPrices(r);
        System.out.println(r1);*/
//        int r = minSumOfLengths(new int[]{4, 3, 2, 6, 2, 3, 4}, 6);
//        System.out.println(r);
        new ProblemWeek20200613().test();
        ;
    }
}
