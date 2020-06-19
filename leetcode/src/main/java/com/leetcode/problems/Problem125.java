package com.leetcode.problems;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * Created by apa7 on 2020/6/19.
 */
public class Problem125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while(l < r && !checkNumAlpha(s.charAt(l))){
                l++;
            }
            while(l < r && !checkNumAlpha(s.charAt(r))){
                r--;
            }
            if (l<=r && !ignoreCaseEq(s.charAt(l++), s.charAt(r--))) {
                return false;
            }
        }
        return true;
    }

    //校验是否数字/字母
    private boolean checkNumAlpha(char c){
        return (c >= '0' && c<='9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    //忽略大小判断是否相等
    private boolean ignoreCaseEq(char c1, char c2){
        return c1 == c2 || (c1 >= 'a' ? c1-'a' : c1-'A') == (c2 >= 'a' ? c2-'a' : c2-'A');
    }

    public static void main(String[] args) {
        Problem125 p = new Problem125();
        p.isPalindrome("`l;`` 1o1 ??;l`");
    }
}
