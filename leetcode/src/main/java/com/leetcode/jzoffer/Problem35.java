package com.leetcode.jzoffer;

/**
 * 面试题35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * <p>
 * <p>
 * 提示：
 * <p>
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * Created by apa7 on 2020/6/5.
 */
public class Problem35 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //1.拷贝到原节点后面，1->2->3变成1->1`->2->2`->3->3`
        for (Node node = head; node != null; ) {
            Node copyNode = new Node(node.val);
            copyNode.next = node.next;
            node.next = copyNode;
            node = copyNode.next;
        }
        //2.处理random  1->1`
        for (Node node = head; node != null; node = node.next.next) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
        }
        //3.分离出新链表1`->2`->3`
        Node currentNode = head;
        Node cloneHead = currentNode.next;
        while (currentNode != null) {
            Node cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return cloneHead;
    }

    public static void main(String[] args) {
        Problem35 p = new Problem35();
        Node node = new Node(1);
        node.setNext(2).setNext(3);
        Node r = p.copyRandomList(node);
        System.out.println(r);
    }

}