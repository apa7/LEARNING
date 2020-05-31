package com.leetcode.jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * <p>
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 * Created by apa7 on 2020/5/31.
 */
public class Problem34 {

    private List<List<Integer>> list = new ArrayList<>();
    private LinkedList<Integer> way = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return list;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        way.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            //注意浅拷贝
            list.add(new ArrayList<>(way));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        //左右子树搜索完毕，删掉当前节点.避免way重复计算.
        way.removeLast();
    }

    public static void main(String[] args) {
        Problem34 p = new Problem34();
        TreeNode root = new TreeNode(5);
        root.setLR(4, 8);
        root.left.setLR(11, null);
        root.left.left.setLR(7, 2);
        root.right.setLR(13, 4);
        root.right.right.setLR(5, 1);
        List<List<Integer>> list = p.pathSum(root, 22);
        System.out.println(list);
    }
}