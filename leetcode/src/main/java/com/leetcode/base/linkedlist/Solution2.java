package com.leetcode.base.linkedlist;


/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * Created by apa7 on 2020/5/19.
 */
public class Solution2 {

    /**
     * 双指针，一个current指向当前，一个fast指向当前+n, 当到末尾（end.next）的时候，当前(cur.next)就是要删的。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode current = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //快指针走完了，说明n要删的是头节点
        if (fast == null) {
            return head.next;
        }
        //两个指针一起移动
        while (fast.next != null) {
            current = current.next;
            fast = fast.next;
        }
        //下一个要删除的
        current.next = current.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(2).setNext(3).setNext(4).setNext(5);
        Solution2 s2 = new Solution2();
        ListNode r = s2.removeNthFromEnd(head, 2);
        System.out.println(r);
    }


}