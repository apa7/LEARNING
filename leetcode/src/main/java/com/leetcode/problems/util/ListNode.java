package com.leetcode.problems.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode setNext(int x) {
        this.next = new ListNode(x);
        return this.next;
    }
}