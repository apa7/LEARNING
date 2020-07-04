package com.leetcode.problems;

/**
 * Created by apa7 on 2020/7/3.
 */
public class Problem415 {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, idx1 = num1.length() - 1, idx2 = num2.length() - 1;
        while (carry != 0 || idx1 >= 0 || idx2 >= 0) {
            if(idx1 >= 0) carry += num1.charAt(idx1--) - '0';
            if(idx2 >= 0) carry += num2.charAt(idx2--) - '0';
            sb.append(carry%10);
            carry/=10;
        }
        return sb.reverse().toString();
    }
}
