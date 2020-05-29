package com.leetcode.jzoffer;

/**
 * 面试题27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * Created by apa7 on 2020/5/29.
 */
public class Problem27 {
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode temp = new TreeNode(0);
        //指针
        temp.left = root;
        mirror(root);
        return temp.left;
    }

    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        //swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归
        mirror(root.left);
        mirror(root.right);
    }


    public static void main(String[] args) {
        Problem27 p = new Problem27();
        TreeNode root = new TreeNode(4);
        root.setLR(2, 7);
        root.left.setLR(1, 3);
        root.right.setLR(6, 9);
        p.mirrorTree(root);
        System.out.println(root);
    }
}