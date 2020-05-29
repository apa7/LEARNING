package com.leetcode.jzoffer;

import java.util.Arrays;

/**
 * 面试题30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 * <p>
 * <p>
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 * <p>
 * * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 * <p>
 * Created by apa7 on 2020/5/29.
 */
public class MinStack {

    private volatile int index = -1;
    private long[] data = new long[8];
    private long[] mindata = new long[8];
    private long min = Long.MAX_VALUE;
    //private static final Unsafe unsafe = Unsafe.getUnsafe();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(long x) {
        data[++index] = x;
        min = Math.min(min, x);
        mindata[index] = min;
        resize();
    }

    public void pop() {
        --index;
        if (index < 0) {
            min = Long.MAX_VALUE;
        } else {
            min = mindata[index];
        }
    }

    public long top() {
        return data[index];
    }

    public long min() {
        return mindata[index];
    }

    /**
     * 扩容.
     * 当插入的数据大小超过负载因子0.75的时候, 数组长度翻倍.
     */
    private void resize() {
        if (index >= 1 - (data.length >> 2)) {
            data = Arrays.copyOf(data, data.length << 1);
            mindata = Arrays.copyOf(mindata, mindata.length << 1);
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-10);
        minStack.push(14);
        System.out.println(minStack.min());
        System.out.println(minStack.min());
        minStack.push(-20);
        System.out.println(minStack.min());
        System.out.println(minStack.min());
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.push(10);
        minStack.push(-7);
        System.out.println(minStack.min());
        minStack.push(-7);
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.pop();
    }

}