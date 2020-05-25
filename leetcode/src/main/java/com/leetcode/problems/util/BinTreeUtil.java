package com.leetcode.problems.util;

/**
 * Created by apa7 on 2020/5/25.
 */
public class BinTreeUtil {

    public static TreeNode build(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            Integer val = arr[i];
            if(val == null){
                continue;
            }
            build(root, val);
        }
        return root;
    }

    public static TreeNode build(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            Integer val = arr[i];
            if(val == null){
                continue;
            }
            build(root, val);
        }
        return root;
    }

    public static void build(TreeNode current, int val) {
        if (val < current.val) {
            //左子树
            if (current.left == null) {
                current.left = new TreeNode(val);
                return;
            } else {
                build(current.left, val);
            }
        } else {
            //右子树
            if (current.right == null) {
                current.right = new TreeNode(val);
                return;
            } else {
                build(current.right, val);
            }
        }
    }
}
