package com.leetcode.jindian;

/**
 * Created by apa7 on 2020/6/7.
 */
public class Problem0201 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int[] arr = new int[20001];
        //初始化数据
        ListNode temp = head;
        arr[temp.val]++;
        while (temp.next != null) {
            int val = temp.next.val;
            arr[val]++;
            if (arr[val] > 1) {
                //说明重复
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Problem0201 p = new Problem0201();
    }
}
