package com.leetcode.problems;

import com.leetcode.problems.util.ListNode;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * Created by apa7 on 2020/5/27.
 */
public class Problem206 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(2).setNext(3).setNext(4).setNext(5);
        Problem206 p = new Problem206();
        p.reverseList(head);
    }

}