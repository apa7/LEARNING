package com.leetcode.jzoffer;

import java.util.Arrays;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *  
 *
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0){
            return null;
        }
        int rootVal = preorder[0];
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(copyOfRange(preorder, 1, rootIndex + 1), copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(copyOfRange(preorder, 1 + rootIndex, preorder.length), copyOfRange(inorder, rootIndex + 1, inorder.length));
        return root;
    }

    public static int[] copyOfRange(int[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0)
            throw new IllegalArgumentException(from + " > " + to);
        int[] copy = new int[newLength];
        System.arraycopy(original, from, copy, 0,
                         Math.min(original.length - from, newLength));
        return copy;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,8,5,4,10,20,15,7};
        int[] inorder = {4,5,8,10,9,3,15,20,7};
        TreeNode treeNode = new Problem7().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

}