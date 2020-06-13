package com.leetcode.zjtd;

/**
 * Created by apa7 on 2020/6/12.
 */
public class Solution2 {

    int div = 0;

    public ListNode sum(ListNode l1, ListNode l2) {
        ListNode head = sum2List(l1, l2);
        if (head != null && head.val >= 10) {
            ListNode pre = new ListNode(head.val / 10);
            head.val = head.val % 10;
            pre.next = head;
            return pre;
        } else {
            return head;
        }
    }

    public ListNode sum2List(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int val = l1 != null ? l2 != null ? l1.val + l2.val : l1.val : l2.val;
        ListNode head = new ListNode(val);
        ListNode sum = sum2List(l1 != null ? l1.next : null, l2 != null ? l2.next : null);
        if (sum != null && sum.val >= 10) {
            div = sum.val / 10;
            sum.val = sum.val % 10;
        }
        head.next = sum;
        head.val += div;
        return head;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        ListNode l1 = new ListNode(9);
        l1.setNext(1).setNext(2);
        ListNode l2 = new ListNode(9);
        l2.setNext(9);
        ListNode r = s.sum(l1, l2);
        System.out.println(r);
    }

}