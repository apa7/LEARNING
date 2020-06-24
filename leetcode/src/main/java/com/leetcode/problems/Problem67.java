package com.leetcode.problems;

import java.util.Arrays;

/**
 * Created by apa7 on 2020/6/23.
 */
public class Problem67 {

    public String addBinary(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int ap = ac.length - 1;
        int bp = bc.length - 1;
        int idx = Math.max(ac.length, bc.length) + 1;
        char[] result = new char[idx];
        int mod = 0;
        while (ap >= 0 || bp >= 0) {
            int i = mod + (ap >= 0 ? ac[ap--] - '0' : 0) + (bp >= 0 ? bc[bp--] - '0' : 0);
            mod = i / 2;
            result[--idx] = i % 2 == 0 ? '0' : '1';
        }
        if (mod > 0) {
            result[0] = '1';
            return new String(result);
        } else {
            return new String(Arrays.copyOfRange(result, 1, result.length));
        }
    }

    public static void main(String[] args) {
        Problem67 pp = new Problem67();
        String r = pp.addBinary("1010", "11");
        System.out.println(r);
    }

}