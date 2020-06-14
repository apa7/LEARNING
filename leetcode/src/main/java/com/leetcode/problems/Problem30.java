package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * Created by apa7 on 2020/6/14.
 */
public class Problem30 {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || "".equals(s) || words == null || words.length == 0) {
            return new ArrayList<Integer>();
        }
        //将每个单词以及出现的频率记录到map中
        Map<String, Integer> initWordsMap = new HashMap<String, Integer>();
        for (String str : words) {
            if (initWordsMap.containsKey(str)) {
                initWordsMap.put(str, initWordsMap.get(str) + 1);
            } else {
                initWordsMap.put(str, 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        int fullLen = words[0].length() * words.length;
        for (int i = 0; i <= s.length() - fullLen; i++) {
            String fullText = s.substring(i, i + fullLen);
            List<String> keys = split(fullText, words.length);
            Map<String, Integer> wordsMap = new HashMap<>(initWordsMap);
            for (int count = 0; count < keys.size(); count++) {
                String key = keys.get(count);
                //子串是否存在 || 重复
                if (!wordsMap.containsKey(key) || wordsMap.get(key) == 0) {
                    break;
                }
                wordsMap.put(key, wordsMap.get(key) - 1);
                if (count == words.length - 1) {
                    //完毕
                    result.add(i);
                }
            }
        }
        return result;
    }

    private List<String> split(String text, int size) {
        List<String> keys = new ArrayList<>();
        int step = text.length() / size;
        for (int i = 0; i < text.length(); i += step) {
            keys.add(text.substring(i, i + step));
        }
        return keys;
    }

    public static void main(String[] args) {
        Problem30 p = new Problem30();
//        "wordgoodgoodgoodbestword"
//                ["word","good","best","good"]
        List<Integer> r = p.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
        System.out.println(r);
    }


}