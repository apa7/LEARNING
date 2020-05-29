package com.leetcode.jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 * Created by apa7 on 2020/5/29.
 */
public class Problem32_3 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int index = 0;
        boolean left2right = true;
        while (index < 3000) {
            if (list.isEmpty()) {
                break;
            }
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                level.add(list.get(i).val);
            }
            left2right = !left2right;
            list = findSub(list, left2right);
            result.add(level);
        }
        return result;
    }

    public LinkedList<TreeNode> findSub(LinkedList<TreeNode> list, boolean left2right) {
        LinkedList<TreeNode> r = new LinkedList<>();
        for (TreeNode treeNode : list) {
            if (left2right) {
                //上一层已经翻转了，所以先取右边再取左边
                if (treeNode.right != null) {
                    r.addFirst(treeNode.right);
                }
                if (treeNode.left != null) {
                    r.addFirst(treeNode.left);
                }
            } else {
                //子节点颠倒插入顺序.
                if (treeNode.left != null) {
                    r.addFirst(treeNode.left);
                }
                if (treeNode.right != null) {
                    r.addFirst(treeNode.right);
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Problem32_3 p = new Problem32_3();
        TreeNode root = new TreeNode(1);
        root.setLR(2, 3);
        root.left.setLR(4, null);
        root.right.setLR(null, 5);
        List<List<Integer>> r = p.levelOrder(root);
        System.out.println(r);
    }

}