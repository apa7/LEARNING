package com.leetcode.jzoffer;

import java.util.Stack;

/**
 * 面试题33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * <p>
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 数组长度 <= 1000
 * Created by apa7 on 2020/5/29.
 */
public class Problem33 {

    /**
     * 单调栈
     * 后序倒序  就是先序的镜像.
     * [1, 3, 2, 6, 5]  -> 倒过来就是 [5, 6, 2, 3, 1]
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        Integer root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            int v = postorder[i];
            if (v > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > v) { //当前小于栈顶元素，说明当前是左子节点，i-2父节点,i-1右兄弟节点
                root = stack.pop();//栈顶元素逐个弹出, 栈底的是父节点
            }
            stack.push(v);
        }
        return true;
    }

    public static void main(String[] args) {
        Problem33 p = new Problem33();
//        [1, 3, 2, 6, 5]
        boolean b = p.verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3});
        System.out.println(b);
    }

}