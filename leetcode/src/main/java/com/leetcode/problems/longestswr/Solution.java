package com.leetcode.problems.longestswr;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 输入: " "
 * 输出: 1
 *
 * <p>
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int len = 0;
        Set<Character> set = new HashSet<Character>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {

                Character val = chars[j];
                if (set.contains(val)) {
                    set.clear();
                    break;
                } else {
                    set.add(val);
                    len++;
                }
            }
            result = len > result ? len : result;
            len = 0;
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int maxSize = 0;
        int [] dict = new int[256]; //记录ASCII 码字符出现的位置，以字符作为下标
        int base = 0;
        int key = 0;
        int i=0;
        while(key < s.length()){
            i = s.charAt(key);
            if(dict[i] > base)
                base = dict[i];
            dict[i] = key+1; //以1作为起始位置，下标加1
            maxSize = (maxSize>key-base+1)?maxSize:key-base+1;
            key++;
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        int len = new Solution().lengthOfLongestSubstring2(str);
        System.out.println(len);
    }

}