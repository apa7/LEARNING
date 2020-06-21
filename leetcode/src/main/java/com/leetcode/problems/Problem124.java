package com.leetcode.problems;


import com.leetcode.problems.util.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 输出: 42
 * Created by apa7 on 2020/6/21.
 */
public class Problem124 {

    int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return ret;
    }

    private int findMax(TreeNode root) {
        if (root == null || root.val <= 0) {
            return 0;
        }
        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));
        ret = Math.max(ret, root.val + left + right);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {

    }

}