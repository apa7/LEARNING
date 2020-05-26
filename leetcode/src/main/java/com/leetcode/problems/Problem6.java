package com.leetcode.problems;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * Created by apa7 on 2020/5/26.
 */
public class Problem6 {

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int fullStep = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            if (row == 0 || row == numRows - 1) {
                //头/尾 增长2N-2
                for (int i = row; i < arr.length; i += fullStep) {
                    sb.append(arr[i]);
                }
            } else {
                //中 增长2N-2-2row 或 2row
                boolean flag = false;
                int midStep = 2 * row;
                for (int i = row; i < arr.length; i += flag ? (fullStep - midStep) : midStep) {
                    sb.append(arr[i]);
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem6 p = new Problem6();
        p.convert("LEETCODEISHIRING", 5);
    }

}