package com.leetcode.jzoffer;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int x) {
        this.val = x;
        this.next = null;
        this.random = null;
    }

    public Node() {

    }

    public Node setNext(int x) {
        this.next = new Node(x);
        return this.next;
    }
}