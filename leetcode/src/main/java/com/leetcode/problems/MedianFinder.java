package com.leetcode.problems;

import java.util.LinkedList;

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

//蛋疼的超时了
class MedianFinder {

    volatile LinkedList<Integer> left;
    volatile LinkedList<Integer> list;
    volatile LinkedList<Integer> right;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        list = new LinkedList<>();
        left = new LinkedList<>();
        left.push(Integer.MIN_VALUE);
        right = new LinkedList<>();
        right.push(Integer.MAX_VALUE);
    }

    public void addNum(int num) {
        if (list.isEmpty()) { // 0个
            list.push(num);
        } else if (list.size() == 1) { // 1个
            if (num < left.getLast()) { //位于左堆
                list.addFirst(left.removeLast());
                addLeft(num);
            } else if (num > right.getFirst()) { //位于右堆
                list.addLast(right.removeFirst());
                addRight(num);
            } else if (num < list.peek()) {
                list.addFirst(num);
            } else {
                list.addLast(num);
            }
        } else { // 2个
            if (num < list.getFirst()) { //位于左堆
                right.addFirst(list.removeLast());
                addLeft(num);
            } else if (num > list.getLast()) { //位于右堆
                left.addLast(list.removeFirst());
                addRight(num);
            } else {
                left.addLast(list.removeFirst());
                right.addFirst(list.removeLast());
                list.push(num);
            }
        }
    }

    private void addRight(int num) {
        if (num >= right.getLast()) {
            right.addLast(num);
        } else if (num <= right.getFirst()) {
            right.addFirst(num);
        } else {
            int idx = 0;
            while (num > right.get(idx)) {
                idx++;
            }
            right.add(idx, num);
        }
    }

    private void addLeft(int num) {
        if (num <= left.getFirst()) {
            left.addFirst(num);
        } else if (num >= left.getLast()) {
            left.addLast(num);
        } else {
            int idx = 0;
            while (num > left.get(idx)) {
                idx++;
            }
            left.add(idx, num);
        }
    }

    public double findMedian() {
        return (list.getFirst() + list.getLast()) / 2.0;
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