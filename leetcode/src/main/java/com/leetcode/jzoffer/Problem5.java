package com.leetcode.jzoffer;

/**
 * Created by apa7 on 2020/5/11.
 */
public class Problem5 {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        String s1 = new Problem5().replaceSpace(s);
        System.out.println(s1);
    }

}
