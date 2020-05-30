package com.leetcode.problems;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * 单调栈分为单调递增栈和单调递减栈
 * 11. 单调递增栈即栈内元素保持单调递增的栈
 * 12. 同理单调递减栈即栈内元素保持单调递减的栈
 * Created by apa7 on 2020/5/30.
 */
public class Problem84 {

    /**
     * 暴力解法
     */
    public int largestRectangleArea1(int[] heights) {
        int maxRang = 0;
        for (int start = 0; start < heights.length; start++) {
            //开始位置固定不动
            int h = heights[start];
            int rang = h;
            for (int end = start + 1; end < heights.length; end++) {
                h = Math.min(h, heights[end]);//到结束位置的最小值
                rang = Math.max(rang, h * (end - start + 1)); //历史最大值和[start,end]之间取最大
            }
            maxRang = Math.max(maxRang, rang);
        }
        return maxRang;
    }

    /**
     * 本题其实可以这么算。对于nums = {2,1,5,6,2,3};
     * 2 * 1，1 * 6，5 * 2，6 * 1，2 * 4，3 * 1的最大值，即为柱形图的最大面积。
     * 高度我们很容易知道，但是宽度怎么计算呢？宽度其实就是从当前位置向左右两边扩散。找到比自己小的或者到达边界截止。
     * <p>
     * 我们可以借用一个栈stack来完成这个功能。stack中的位置对于nums的值保持严格递增。
     * 首先位置0进栈，stack = {0};
     * 然后位置1要进栈的话，显然就不满足递增的条件了。栈里面的数需要出栈，一直到栈为空栈顶小于等于待入栈的值为止。这样做有什么好处？
     * 首先，我们已经知道了栈顶的在nums的值比待入栈位置在nums的值小。又因为栈里面位置在nums的值是严格递增的。
     * 因为栈是严格递增的。所以弹出某个数的时候，剩余的栈顶就是其左边界的前一位。而待入栈的数就是其右边界。
     * 因此。如果stack不为空，宽度width = i-stack.peek()-1，如果为空的话。宽度为i。
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        // 使用单调栈, 保存数组下标. 栈自底向顶递增. 这样就能确定左边的边界.
        Stack<Integer> stack = new Stack<>();
        int maxRang = 0;
        stack.push(0);
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                //假设是栈顶元素是左边界
                int left = stack.pop();
                //max(历史最大，[left,i]面积)
                maxRang = Math.max(maxRang, heights[i] * (i - left + 1));
            }
            //递增，入栈
            if (!stack.isEmpty()) {
                maxRang = Math.max(maxRang, heights[stack.peek()] * (i - stack.peek() + 1));
            }
            stack.push(i);
        }
        //处理栈中剩余元素，比如[2,1,3,2,1]剩下最后一个4
        while (!stack.isEmpty()) {
            int last = stack.pop();
            if (stack.isEmpty()) {
                maxRang = Math.max(maxRang, heights[last] * heights.length);
            } else {
                maxRang = Math.max(maxRang, heights[last] * (heights.length - stack.peek() - 1));
            }
        }
        return maxRang;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,0}; //这样计算有问题，如何解决呢?
        Problem84 p = new Problem84();
        int r = p.largestRectangleArea(arr);
        System.out.println(r);
    }
}