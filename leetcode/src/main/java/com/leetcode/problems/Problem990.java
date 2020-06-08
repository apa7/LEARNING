package com.leetcode.problems;

/**
 * 990. 等式方程的可满足性
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * <p>
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 * <p>
 * 输出：["b==a","a==b"]
 * 输入：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 * <p>
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 * 通过次数8,764提交次数19,993
 * Created by apa7 on 2020/6/8.
 */
public class Problem990 {

    //TODO  并查集
    public boolean equationsPossible(String[] equations) {
        int[] col1 = new int[26];
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                col1[equation.charAt(0) - 'a'] = 1;
                col1[equation.charAt(3) - 'a'] = 1;
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if(col1[equation.charAt(0) - 'a'] == 0){

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem990 p = new Problem990();
        boolean r = p.equationsPossible(new String[]{"a==b", "b==c", "a!=c"});
        System.out.println(r);
    }

}