package com.leetcode.jzoffer;

/**
 * 面试题52. 两个链表的第一个公共节点
 * Created by apa7 on 2020/6/3.
 */
public class Problem52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }

    public static void main(String[] args) {
        Problem52 p = new Problem52();
        ListNode n1 = new ListNode(6).setNext(4).setNext(3);
        ListNode n2 = new ListNode(5).setNext(4).setNext(3);
        ListNode v = p.getIntersectionNode(n1, n2);
        System.out.println(v);
    }

}