package com.leetcode.jzoffer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * Created by apa7 on 2020/7/1.
 */
public class Problem58 {

    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) return "";
        String[] sarr = s.split(" ");
        List<String> list = Arrays.asList(sarr);
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (String s1 : list) {
            if (s1.length() > 0 && s1.contains(" ")) continue;
            sb.append(s1).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Problem58 problem58 = new Problem58();
        String r = problem58.reverseWords(" the   sky is blue");
        System.out.println(r);
    }
}
