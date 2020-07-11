package com.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by apa7 on 2020/7/9.
 */
public class Problem1615 {

    public int[] masterMind(String solution, String guess) {
        int hit = 0;
        int udohit = 0;
        char[] sc = solution.toCharArray();
        char[] gc = guess.toCharArray();
        //len(solution) = len(guess) = 4
        for (int i = 0; i < gc.length; i++) {
            if (gc[i] == sc[i]) {
                gc[i] = sc[i] = '/';
                hit++;
            }
        }
        int[] dict = new int[128];
        for (char s : sc) {
            dict[s]++;
        }
        for (int i = 0; i < gc.length; i++) {
            if (gc[i] != '/' && dict[gc[i]] > 0) {
                dict[gc[i]]--;
                udohit++;
            }
        }
        return new int[]{hit, udohit};
    }

    public static void main(String[] args) {
        int[] r = new Problem1615().masterMind(
                "BGBG",
                "RGBR");
        System.out.println(r);
    }
}