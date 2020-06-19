package com.leetcode.problems;

import java.util.LinkedList;

/**
 * 面试题 03.02. 栈的最小值
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * Created by apa7 on 2020/6/18.
 */
public class Problem1038 {

    class MinStack {

        LinkedList<Integer> stack;
        int min = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
        }

        public void push(int x) {
            if (x > min) {
                stack.push(x);
            } else {
                stack.push(min);
                stack.push(x);
                min = x;
            }
        }

        public void pop() {
            if (stack.peek() > min) {
                stack.poll();
            } else {
                stack.poll();
                min = stack.poll();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
