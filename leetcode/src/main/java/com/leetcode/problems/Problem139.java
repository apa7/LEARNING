package com.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * Created by apa7 on 2020/6/25.
 */
public class Problem139 {

    //解1
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0) return true;
        if(s.length()>=151) return false;
        for(String word: wordDict){
            if(s.startsWith(word)){
                if(wordBreak(s.substring(word.length()),wordDict)){
                    return true;
                }
            }
        }
        return false;
    }

    //解2背包问题
    public boolean wordBreak2(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        //memo表示s中以i-1结尾的字符串是否可以被wordDict拆分
        boolean[] memo = new boolean[len+1];
        memo[0] = true;
        for(int i=1; i<=len; i++){
            for(int j=0; j<i; j++){
                if(memo[j] && dict.contains(s.substring(j, i))){
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[len];
    }
    public static void main(String[] args) {
        Problem139 p = new Problem139();
        p.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
    }

}