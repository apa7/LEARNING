package com.leetcode.jzoffer;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Created by apa7 on 2020/5/11.
 * 解题思路：
 * 先获取链表长度，然后创建数组，迭代一次将序号倒过来插进去即可。
 * 复杂度O(n)
 */
public class Problem6 {
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        int[] arr = new int[count];
        while (head != null) {
            arr[--count] = head.val;
            head = head.next;
        }
        return arr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode next = head;
        for (int i = 0; i < 10; i++) {
            next.next = new ListNode(i);
            next = next.next;
        }
        int[] arr = new Problem6().reversePrint(head);
        System.out.println(arr);
    }

}
