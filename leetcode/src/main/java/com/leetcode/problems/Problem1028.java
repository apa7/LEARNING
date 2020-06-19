package com.leetcode.problems;

import com.leetcode.problems.util.TreeNode;

/**
 * 1028. 从先序遍历还原二叉树
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 * <p>
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * <p>
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * <p>
 * 给出遍历输出 S，还原树并返回其根节点 root。
 * 示例 1：
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 * 提示：
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 * Created by apa7 on 2020/6/18.
 */
public class Problem1028 {

    //树的节点
    int[] nodes = new int[1001];
    //节点对应的层级
    int[] levels = new int[1001];
    int maxIdx = 0;

    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        int level = 1;
        boolean isNum = false;
        for (char c : S.toCharArray()) {
            if (c == '-') {
                level++;
                if (isNum) {
                    maxIdx++;
                }
                isNum = false;
            } else {
                if (!isNum) {
                    levels[maxIdx] = level;
                    level = 1;
                }
                nodes[maxIdx] = nodes[maxIdx] * 10 + c - '0';
                isNum = true;
            }
        }
        //根据节点和层级创建数
        return create(0);
    }

    int index = 0;

    public TreeNode create(int parentLevel) {
        if (index > maxIdx || levels[index] <= parentLevel) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[index++]);
        root.left = create(parentLevel + 1);
        root.right = create(parentLevel + 1);
        return root;
    }

    public static void main(String[] args) {
        Problem1028 p = new Problem1028();
        TreeNode treeNode = p.recoverFromPreorder("1-401--349---90--88");
        System.out.println(treeNode);
    }
}