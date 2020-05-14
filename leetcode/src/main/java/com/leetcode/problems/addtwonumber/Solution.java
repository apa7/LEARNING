package com.leetcode.problems.addtwonumber;

/**
 * Definition for singly-linked list.
 * public class com.leetcode.problems.addtwonumber.ListNode {
 * int val;
 * com.leetcode.problems.addtwonumber.ListNode next;
 * com.leetcode.problems.addtwonumber.ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode nextNode = null;
        int seg = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) l1 = new ListNode(0);
            if (l2 == null) l2 = new ListNode(0);
            int sum = l1.val + l2.val + seg;
            seg = sum / 10;
            sum = sum % 10;
            if (result == null) {
                //第一次进来
                result = new ListNode(sum);
            } else if (nextNode == null) {
                //第二次
                nextNode = new ListNode(sum);
                result.next = nextNode;
            } else {
                nextNode.next = new ListNode(sum);
                nextNode = nextNode.next;
            }
            l1 = l1.next != null ? l1.next : null;
            l2 = l2.next != null ? l2.next : null;
        }
        if (seg > 0) {
            if (nextNode == null) {
                //第二次
                nextNode = new ListNode(seg);
                result.next = nextNode;
            } else {
                nextNode.next = new ListNode(seg);
            }
        }
        return result;
    }

}

