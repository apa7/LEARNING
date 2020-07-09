package com.leetcode.problems;

import java.util.Arrays;

/**
 * 820. 单词的压缩编码
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * <p>
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * <p>
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * <p>
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * 每个单词都是小写字母 。
 * 通过次数38,227提交次数77,927
 * Created by apa7 on 2020/7/9.
 */
public class Problem820 {

    class Solution {
        public int minimumLengthEncoding(String[] words) {
            int len = 0;
            Trie trie = new Trie();
            //先对单词列表根据单词长度由长到短排序
            Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
            //单词插入trie，返回该单词增加的编码长度
            for (String word : words) {
                len += trie.insert(word);
            }
            return len;
        }
    }

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public int insert(String word) {
            TrieNode cur = root;
            boolean isNew = false;
            char[] wcs = word.toCharArray();
            //倒着插入单词
            for (int i = wcs.length - 1; i >= 0; i--) {
                int c = wcs[i] - 'a';
                if (cur.children[c] == null) {
                    isNew = true; //是新单词
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            //如果是新单词的话，编码长度增加新单词的长度+1，否则不变
            return isNew ? wcs.length + 1 : 0;
        }

    }

    class TrieNode {
        char val;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }
    }
}
