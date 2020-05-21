package com.leetcode.jzoffer;

/**
 * 面试题18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * <p>
 * 说明：
 * <p>
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * Created by apa7 on 2020/5/18.
 */
public class Problem18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        while (pre != null) {
            ListNode next = pre.next;
            if (next != null && next.val == val) {
                pre.next = next.next;
                return head;
            }
            pre = pre.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.setNext(1).setNext(2).setNext(3).setNext(4).setNext(5);
        Problem18 p = new Problem18();
        ListNode listNode = p.deleteNode(head, 0);
        System.out.println(listNode);
    }

}
