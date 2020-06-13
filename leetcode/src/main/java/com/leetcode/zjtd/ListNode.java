package com.leetcode.zjtd;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode setNext(int x) {
        this.next = new ListNode(x);
        return this.next;
    }
}