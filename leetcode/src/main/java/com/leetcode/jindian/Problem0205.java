package com.leetcode.jindian;

/**
 * Created by apa7 on 2020/6/8.
 */
public class Problem0205 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);
        ListNode cur = temp;
        int mod = 0;
        while(l1 != null && l2 != null){
            int v = l1.val + l2.val;
            mod += v;
            cur.next = new ListNode(mod % 10);
            cur = cur.next;
            mod = mod / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(1);
        l2.setNext(2).setNext(3);
        ListNode node = new Problem0205().addTwoNumbers(l1, l2);
        System.out.println(node);
    }
}
