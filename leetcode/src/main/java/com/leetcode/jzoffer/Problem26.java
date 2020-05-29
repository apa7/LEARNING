package com.leetcode.jzoffer;


/**
 * 面试题26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 * <p>
 * Created by apa7 on 2020/5/29.
 */
public class Problem26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return A != null && B != null && (
                isSubTree(A, B) ||

                isSubStructure(A.left, B) ||

                isSubStructure(A.right, B)
        );
    }

    public boolean isSubTree(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || B.val != A.val) {
            return false;
        }
        return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
    }

    public static void main(String[] args) {
        Problem26 p = new Problem26();
        TreeNode t1 = new TreeNode(4).setLR(2, 3);
        t1.left.setLR(4, 5);
        t1.left.left.setLR(8, 9);
        t1.right.setLR(6, 7);

        TreeNode t2 = new TreeNode(4).setLR(8, 9);
        boolean b = p.isSubStructure(t1, t2);
        System.out.println(b);
    }
}