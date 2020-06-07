package com.leetcode.jindian;

/**
 * Created by apa7 on 2020/6/7.
 */
public class Problem0105 {

    public boolean oneEditAway(String first, String second) {
        if ((first == null && second == null) || (first.length() == 0 && second.length() == 0)) {
            return true;
        }
        int len1 = first.length(), len2 = second.length();
        int idx1 = 0, idx2 = 0;
        int diff = 0;
        char[] arr1 = first.toCharArray();
        char[] arr2 = second.toCharArray();
        while (idx1 < len1 && idx2 < len2) {
            if (arr1[idx1] == arr2[idx2]) {
                idx1++;
                idx2++;
                continue;
            }
            //第一次出现不同
            //索引越界，跳出去走最后判断剩余字符的逻辑
            diff++;
            if (idx1 + 1 < len1 && arr1[idx1 + 1] == arr2[idx2]) {
                idx1++;
                continue;
            }
            if (idx2 + 1 < len2 && arr1[idx1] == arr2[idx2 + 1]) {
                idx2++;
                continue;
            }
            idx1++;
            idx2++;
        }
        //存在pales,pal这种剩余的情况.用idx+1去减长度就知道剩余多少了。
        return Math.abs(idx1 - len1) + Math.abs(idx2 - len2) + diff <= 1;
    }

    public static void main(String[] args) {
        Problem0105 p = new Problem0105();
        boolean b = p.oneEditAway("ab", "b");
        System.out.println(b);
    }

}
