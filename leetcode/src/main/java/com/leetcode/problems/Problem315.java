package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 315. 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * Created by apa7 on 2020/7/11.
 * <p>
 * 先来想一个问题：
 * <p>
 * 当一个队伍，插入一个新同学的时候，如何知道有几个人身高比他矮呢？
 * 如果这个队伍的人并不是按照身高从低到高的顺序排列的话，那没办法，只能一个一个数了。如果这个队伍是有序的呢，只要找到插入的位置，就能直接计算出来比他矮的同学的个数了。
 * <p>
 * 在这个题目里，要想知道一个数后面比它小的数有多少个，只要找到新数字插入的位置就能判断出有几个比它小的（假设比它后面的数字都已经排好序了）。来一个例子。
 * <p>
 * [1,3,6,1,2,3]
 * <p>
 * input 3,  output: [3] -> 3 左边有 0 个数
 * input 2,  output: [2,3] -> 2 左边有 0 个数
 * input 1,  output: [1,2,3] -> 1 左边有 0 个数
 * input 6,  output: [1,2,3,6] -> 6 左边有 3 个数
 * input 3', output: [1,2,3',3,6] -> 3' 左边有 2 个数
 * input 1', output: [1',1,2,3',3,6] -> 1' 左边有 0 个数
 * 可以看到，在不断插入的过程中，能根据插入的位置判断出比它小的数有多少个。虽然插入的位置查找速度是 logn 的，但是插入过程却要移动元素，复杂度是 n，这个成本非常高。
 * <p>
 * 如果有一种办法，查找速度很快 logn，插入的速度也很快，O(1)，那多好。链表不行，虽然插入是 O(1)，但是查找却无法做到 log(n).
 * <p>
 * 那就只剩下树了。把上面的数组换成 bst (binary-search-tree)，一切就好办了。只要维护好这棵树就行。这里就不解释太多了，其它的答案都有很详细的说明。
 * <p>
 * 利用二叉搜索树的特性：左边节点的值小于等于当前节点值，右边节点的值大于等于当前节点值。
 * <p>
 * 那么实现算法首先要构建一颗二叉搜索树：
 * <p>
 * 定义树的节点结构 TreeNode
 * 实现树的节点插入方法 insertNode
 * 其中， insertNode 方法需要实现几个功能：
 * <p>
 * 构建二叉树
 * 维护每个节点中其左子树节点数量值 count：如果新加入的节点需要加入当前节点的左子树，则当前节点的 count += 1
 * 计算出新加入节点 nums[i] 的 "右侧小于当前元素的个数"，即题目所求值 res[i]
 */
public class Problem315 {

    int[] res;

    public List<Integer> countSmaller(int[] nums) {
        Node root = null;
        res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int re : res) {
            list.add(re);
        }
        return list;
    }

    Node insert(Node root, int val, int index) {
        if (root == null) {
            return new Node(val);
        }
        if (val <= root.val) {
            root.count++;
            root.left = insert(root.left, val, index);
        } else {
            res[index] += root.count + 1;
            root.right = insert(root.right, val, index);
        }
        return root;
    }

    class Node {
        int val;
        int count = 0; //左子数节点数
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        new Problem315().countSmaller(new int[]{1, 2, 5, 3, 2, 1});
    }

}