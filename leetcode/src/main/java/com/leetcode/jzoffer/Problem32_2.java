package com.leetcode.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 * Created by apa7 on 2020/5/29.
 */
public class Problem32_2 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result =new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int index = 0;
        while (index < 3000) {
            if (list.isEmpty()) {
                break;
            }
            List<Integer> level = new ArrayList<>();
            for (TreeNode treeNode : list) {
                level.add(treeNode.val);
            }
            list = findSub(list);
            result.add(level);
        }
        return result;
    }

    public List<TreeNode> findSub(List<TreeNode> list) {
        List<TreeNode> r = new ArrayList<>();
        for (TreeNode treeNode : list) {
            if (treeNode.left != null) {
                r.add(treeNode.left);
            }
            if (treeNode.right != null) {
                r.add(treeNode.right);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Problem32_2 p = new Problem32_2();
        TreeNode root = new TreeNode(3);
        root.setLR(9, 20);
        root.right.setLR(15, 7);
        List<List<Integer>> r = p.levelOrder(root);
        System.out.println(r);
    }

}