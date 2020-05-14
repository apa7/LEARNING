package com.leetcode.jzoffer;

/**
 * 面试题12. 矩阵中的路径
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [['a','b','c','e'],
 * ['s','f','c','s'],
 * ['a','d','e','e']]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [['a','b'],['c','d']], word = 'abcd'
 * 输出：false
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 * Created by apa7 on 2020/5/14.
 * <p>
 * 解题思路：
 * 本问题是典型的矩阵搜索问题，可使用 深度优先搜索（DFS）+ 剪枝 解决。
 * 从二维数组[0][0]开始搜索上下左右，找不到从二维数组下一个位置搜索。
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
 */
public class Problem12 {

    /**
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, char[] words, int wordsIdx) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || wordsIdx > words.length - 1) {
            //越界
            return false;
        }
        if (board[i][j] != words[wordsIdx]) {
            //该搜索方向不匹配
            return false;
        }
        if (wordsIdx == words.length - 1) {
            //最后一个字已匹配，回溯。
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean result = dfs(board, i + 1, j, words, wordsIdx + 1) ||   //下
                         dfs(board, i - 1, j, words, wordsIdx + 1) ||   //上
                         dfs(board, i, j + 1, words, wordsIdx + 1) ||   //右
                         dfs(board, i, j - 1, words, wordsIdx + 1);     //左
        board[i][j] = tmp;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Problem12 p = new Problem12();
        boolean exist = p.exist(board, "ADFE");
        System.out.println(exist);
    }

}