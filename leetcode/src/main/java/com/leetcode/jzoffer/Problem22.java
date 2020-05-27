package com.leetcode.jzoffer;

/**
 * 面试题22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * Created by apa7 on 2020/5/27.
 */
public class Problem22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = slow;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Problem22 p = new Problem22();
        ListNode head = new ListNode(1);
        head.setNext(2).setNext(3).setNext(4).setNext(5);
        ListNode r = p.getKthFromEnd(head, 2);
        System.out.println(r);
    }

}