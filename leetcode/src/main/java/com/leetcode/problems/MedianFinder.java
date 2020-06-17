package com.leetcode.problems;

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */

/**
 * 把一个数据流进行处理，一般都是分半处理。
 * 通常我们用到的方法是暴力解法，类似插入排序，但是时间复杂度是0(N)，在这里，我们不会采用这个方法。
 * 此题我们采用两个heap，一个maxheap和一个minheap来进行处理，在heap中插入num的时间复杂度是O（logn），所以快捷了很多。
 * <p>
 * 思路：
 * <p>
 * 我们需要明确，对于此题而言，找到median就意味着，我们可以将此数据流分为两部分，即第一部分值全部小于median（or =），第二部分值全部大于median（or =）。
 * 所以我们用maxheap存第一部分，并按照倒序存放；minheap来存第二部分，并按照顺序排放。
 * 我们先立下一个约定☝️，即maxheap总比minheap多一个，方便于我们之后进行查找。这样一来，初始第一个值就加入maxheap。
 * 比较即将加入进heap的数字与两个堆堆顶的数字，若大于maxheap，则需要放进minheap中。
 * 在后面陆续的增加中，我们只需保持两个heap size之间的关系，不断进行调节即可。
 * 关于查找，那就只有两个地方可以找到median：如果是奇数，median肯定在maxheap的堆顶，直接输出即可；若是偶数，我们需要取出两个堆各自的堆顶元素，取其均值，再输出。
 * <p>
 */
class MedianFinder {

    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        leftHeap = new PriorityQueue<>((a, b) -> b - a);//顶部是最大
        rightHeap = new PriorityQueue<>((a, b) -> a - b);//顶部是最小
    }

    public void addNum(int num) {
        if (leftHeap.size() == 0 || num <= leftHeap.peek()) {
            leftHeap.offer(num);
        } else {
            rightHeap.offer(num);
        }

        //exchange element because leftHeap must be larger than rightHeap.
        if (leftHeap.size() > rightHeap.size() + 1) {
            rightHeap.add(leftHeap.poll());
        } else if (leftHeap.size() < rightHeap.size()) {
            leftHeap.add(rightHeap.poll());
        }
    }

    public double findMedian() {
        if (leftHeap.size() != rightHeap.size()) {
            return leftHeap.peek();
        } else {
            return leftHeap.peek() / 2.0 + rightHeap.peek() / 2.0;
        }
    }


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.addNum(7);
        medianFinder.addNum(8);
        medianFinder.addNum(9);
        medianFinder.addNum(10);
        double r = medianFinder.findMedian();
        System.out.println(r);
    }
}