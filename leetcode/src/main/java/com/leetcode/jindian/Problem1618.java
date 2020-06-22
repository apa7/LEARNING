package com.leetcode.jindian;

/**
 * Created by apa7 on 2020/6/22.
 */
public class Problem1618 {

    public boolean patternMatching(String pattern, String value) {
        int numa = 0, numb = 0;
        char[] patterns = pattern.toCharArray();
        for (char c : patterns) {
            if (c == 'a') {
                numa++;
            } else {
                numb++;
            }
        }
        //特殊处理
        int len = value.length();
        if (value.length() == 0) {
            return numa == 0 || numb == 0;
        } else if (pattern.length() == 0) {
            return false;
        }
        char[] values = value.toCharArray();
        //全b
        if (numa == 0) {
            return len % numb == 0 && helper(values, patterns, 0, 0, 0, len / numb);
        }
        //全a
        if (numb == 0) {
            return len % numa == 0 && helper(values, patterns, 0, 0, len / numa, 0);
        }
        //a前有几个b, b前有几个a, 用来计算第一个a,b的起始位置
        int idxa = pattern.indexOf('a');
        int idxb = pattern.indexOf('b');
        int lena = 0, lenb = 0;
        while (lena * numa <= len) {
            //lenb = (len - lena*numa) / numb;
            if ((len - lena * numa) % numb == 0 && helper(values, patterns, idxa * (len - lena * numa) / numb, idxb * lena, lena, (len - lena * numa) / numb)) {
                return true;
            }
            lena++;
        }
        return false;
    }

    private boolean helper(char[] values, char[] patterns, int indexa, int indexb, int lena, int lenb) {
        // 当前比对的索引
        int index = 0;
        for (char c : patterns) {
            if (c == 'a') {
                // 和第一个a比对
                for (int i = 0; i < lena; i++) {
                    if (values[index++] != values[indexa + i]) return false;
                }
            } else {
                // 和第一个b比对
                for (int i = 0; i < lenb; i++) {
                    if (values[index++] != values[indexb + i]) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem1618 pp = new Problem1618();
        pp.patternMatching("bbbaa", "xxxxxxy");
    }
}
