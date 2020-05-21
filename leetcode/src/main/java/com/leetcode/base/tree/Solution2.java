package com.leetcode.base.tree;

/**
 *
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * Created by apa7 on 2020/5/20.
 */
public class Solution2 {

    /**
     * root.parent.val
     * 父节点的值
     */
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //验证左子树
        if (isValidBST(root.left)) {
            if (pre < root.val) { // 所有右子树大于中值
                //验证右子树
                pre = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        Solution2 s1 = new Solution2();
        boolean r = s1.isValidBST(root);
        System.out.println(r);
    }
}