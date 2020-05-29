package com.leetcode.problems;

import java.util.LinkedList;

/**
 * 面试题19. 正则表达式匹配  未解决
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 * 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
 * Created by apa7 on 2020/5/29.
 */
public class Problem19 {


    public boolean isMatch(String s, String p) {
        if (s == null || s.isEmpty()) {
            return p == null || p.isEmpty() || p.contains("*");
        }
        LinkedList<Character> pstack = new LinkedList<>();
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();
        for (char pc : parr) {
            pstack.push(pc);
        }
        char repeat = '/';
        int i = sarr.length - 1;
        while (i >= 0) {
            char c = sarr[i];
            Character pc = pstack.pop();
            if (pc == '.') {
                continue;
            }
            if (pc == '*' && pstack.size() > 0) {
                Character pre = pstack.pop();
                if (pre == '.') {
                    if (pstack.size() == 0) {
                        //??xx=.*xx 直接结束
                        return true;
                    }
                    repeat = pstack.pop();
                    if (repeat == '.') {

                    }
                    while (i > 0 && sarr[i--] == repeat) {
                    }
                    continue;
                } else {
                    repeat = pre;
                    while (i > 0 && sarr[i--] == repeat) {
                    }
                    continue;
                }
            }
        }
        /*
        final char any = '.';
        final char common = '*';
        char pre = '/'; // 1代表.*,
        int si = 0;
        for (char pc : parr) {
            if (pc == '.') {
                si++;
            }
            if (pc == '*') {
                if (pre == '.') {
                    //.*

                }
            }
        }*/
        /*for (char c : sarr) {
            if (pre == any) {
                char repeat = parr[++pi];
                if (repeat == common) {
                    //.*
                    return true;
                }
                pre = repeat;
                continue;
            }
            if (pre == any) {
                if (c == common) {
                    //.*
                    return true;
                } else {
                    //.x
                    pre = '/';
                    continue;
                }
            }
            if (c == common) {
                pre
            }
            //字母
        }*/
        return true;
    }

    public static void main(String[] args) {
        Problem19 p = new Problem19();
        boolean r = p.isMatch("aa", "a");
        System.out.println(r);
    }
}