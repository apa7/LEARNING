package com.leetcode.problems;

import com.leetcode.problems.util.BinTreeUtil;
import com.leetcode.problems.util.TreeNode;

/**
 * 226. 翻转二叉树
 * <p>
 * Created by apa7 on 2020/5/25.
 */
public class Problem226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invert(root);
        return root;
    }

    private void invert(TreeNode current) {
        if (current == null) {
            return;
        }
        swapLeftAndRight(current);

        invert(current.left);
        invert(current.right);
    }

    /**
     * 交换左右子树
     */
    private void swapLeftAndRight(TreeNode current) {
        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3, 6, 9};
        Problem226 p = new Problem226();
        p.invertTree(BinTreeUtil.build(arr));
    }

}