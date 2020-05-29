package com.leetcode.jzoffer;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode setLR(Integer l, Integer r) {
        if (l != null) {
            this.left = new TreeNode(l);
        }
        if (r != null) {
            this.right = new TreeNode(r);
        }
        return this;
    }
}