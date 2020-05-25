package com.leetcode.problems;

import com.leetcode.problems.util.TreeNode;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 * Created by apa7 on 2020/5/25.
 */
public class Problem617 {


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return merge(t1, t2);
    }


    public TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return t1;
        }
        if (t1 == null) {
            return t2;
        }
        t1.val = t1.val + t2.val;
        t1.left = merge(t1.left, t2.left);
        t1.right = merge(t1.right, t2.right);
        return t1;
    }


    public static void main(String[] args) {
        Problem617 p = new Problem617();
        TreeNode left = new TreeNode(1);
        left.left = new TreeNode(3);
        left.left.left = new TreeNode(5);
        left.right = new TreeNode(2);

        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(1);
        right.left.right = new TreeNode(4);
        right.right = new TreeNode(3);
        right.right.right = new TreeNode(7);
        TreeNode r = p.mergeTrees(left, right);
        System.out.println(r);
    }

}