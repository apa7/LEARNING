package com.leetcode.problems;

/**
 * 97. 交错字符串
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * Created by apa7 on 2020/7/18.
 * DFS+剪枝+记忆化
 * 这个递归的时候，如果当前s1.charAt(idx1)或者s2.charAt(idx2)与s3.charAt(idx3)匹配，才进行递归，否则直接为false
 */
public class Problem97 {


    int[][] mem;

    public boolean isInterleave(String s1, String s2, String s3) {
        mem = new int[s1.length() + 1][s2.length() + 1];
        return s1.length() + s2.length() == s3.length() && dfs(s1, s2, s3, 0, 0, 0);
    }

    boolean dfs(String s1, String s2, String s3, int idx1, int idx2, int idx3) {
        if (mem[idx1][idx2] != 0) {
            return mem[idx1][idx2] == 1;
        }
        if (idx3 == s3.length()) {
            return idx1 >= s1.length() && idx2 >= s2.length();
        }
        if (idx1 < s1.length() && s3.charAt(idx3) == s1.charAt(idx1) && dfs(s1, s2, s3, idx1 + 1, idx2, idx3 + 1)) {
            return true;
        }
        if (idx2 < s2.length() && s3.charAt(idx3) == s2.charAt(idx2) && dfs(s1, s2, s3, idx1, idx2 + 1, idx3 + 1)) {
            return true;
        }
        mem[idx1][idx2] = -1;
        return false;
    }

    /**
     * 题目的交错方式有讲究：交错从s1和s2拿元素，但每次可能拿多个
     * <p>
     * 示例1的交错方式为：
     * <p>
     * s1: aa    bc     c
     * s2:    db    bca
     * 所以，如果s1的前i个字符和s2的前j个字符，能够交替拼出s3的前i+j个字符的话， 那么，s3的下一个字符随便从s1还是s2拿都是有可能的。
     * <p>
     * 理解了这一点，递推关系就有了：
     * <p>
     * 令f(i,j) 表示 s1 的前 i 个字符和 s2 的前 j 个字符能否交错组成 s3的前 i+j 个字符。
     * <p>
     * 递推关系： 令p = i+j-1, f(0,0)=true, 则f(i,j)有两种情况为真：
     * <p>
     * 1、f(i-1,j) && s1[i-1]==s3[p]
     * 2、f(i,j-1) && s2[j-1]==s3[p]
     */
    public boolean isInterleave3(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[n][m];
    }

    public boolean isInterleave31(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[m];
    }
    //        if (idx1 < s1.length()) {//递归+剪枝
//            if (s1.charAt(idx1) == s3.charAt(idx3) && dfs(s1, s2, s3, idx1 + 1, idx2, idx3 + 1)) return true;
//        }
//        if (idx2 < s2.length()) {
//            if (s2.charAt(idx2) == s3.charAt(idx3) && dfs(s1, s2, s3, idx1, idx2 + 1, idx3 + 1)) return true;
//        }
//        //mem[idx1][idx2] = -1;
//        return false;

    public boolean isInterleave2(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        // 如果字符串长度不同则一定为false
        if (len1 + len2 != len3) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 2];
        // 初始状态
        dp[0][0] = true;
        // 初始化dp数组的第一行与第一列
        for (int i = 1; i <= len1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) dp[i][0] = true;
            else break;
        }
        for (int i = 1; i <= len2; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) dp[0][i] = true;
            else break;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int sum = i + j;   // sum为当前定位到的s3字符串的索引

                // 判断dp[i-1][j]或dp[i][j-1]是否true
                if (dp[i - 1][j] || dp[i][j - 1]) dp[i][j] =
                        (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(sum - 1)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(sum - 1));
            }
        }
        // 输出 DP 数组
        // for (int i = 0; i <= len1; i++) {
        //     for (int j = 0; j <= len2; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        boolean r = new Problem97().isInterleave("aabcc",
                                                 "dbbca",
                                                 "aadbbcbcac");
        System.out.println(r);
    }

}