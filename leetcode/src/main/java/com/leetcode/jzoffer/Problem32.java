package com.leetcode.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 * 通过次数16,736提交次数26,093
 * Created by apa7 on 2020/5/29.
 */
public class Problem32 {


    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        int[] arr = new int[3000];
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int index = 0;
        while (index < 3000) {
            if (list.isEmpty()) {
                break;
            }
            for (TreeNode treeNode : list) {
                arr[index++] = treeNode.val;
            }
            list = findSub(list);
        }
        return Arrays.copyOf(arr, index);
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
        Problem32 p = new Problem32();
        TreeNode root = new TreeNode(3);
        root.setLR(9, 20);
        root.right.setLR(15, 7);
        int[] ints = p.levelOrder(root);
        System.out.println(ints);
    }

}