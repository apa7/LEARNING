package com.leetcode.jzoffer;

import java.util.LinkedList;

/**
 * 9.用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * <p>
 * 输入：
 * <p>
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * 这一行表示每一行代码的操作
 * [[],[3],[],[]]
 * 这个表示每一行代码操作后对应的结果
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by apa7 on 2020/5/12.
 */
public class Problem9 {

    public static class CQueue {

        LinkedList<Integer> stack = new LinkedList();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack.addLast(value);
        }

        public int deleteHead() {
            return stack.isEmpty() ? -1 : stack.pop();
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

}