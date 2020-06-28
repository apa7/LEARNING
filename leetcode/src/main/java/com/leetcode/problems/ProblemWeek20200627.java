package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by apa7 on 2020/6/21.
 */
public class ProblemWeek20200627 {

    public int longestSubarray(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        int count = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else if (count > 0) {
                list.addLast(count);
                count = 0;
            } else {
                list.addLast(0);
            }
        }
        if (count > 0) {
            list.addLast(count);
        }
        if (list.isEmpty()) return 0;
        if (count == nums.length) return count - 1; //不删除
        if (list.size() == 1) return count;
        Integer[] dp = list.toArray(new Integer[list.size()]);
        Integer[] arr = list.toArray(new Integer[list.size()]);
        for (int i = 1; i < list.size(); i++) {
            dp[i] = Math.max(dp[i - 1], arr[i] + arr[i - 1]);
        }
        return dp[list.size() - 1];
    }


    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        LinkNode[] list = new LinkNode[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new LinkNode(i);
        }
        Map<Integer, List<LinkNode>> levelMap = new TreeMap<>();
        for (int i = 0; i < dependencies.length; i++) {
            list[dependencies[i][1]].next = list[dependencies[i][0]];
            list[dependencies[i][1]].len = Math.max(list[dependencies[i][1]].len, 1 + list[dependencies[i][0]].len);
        }
        for (int i = dependencies.length-1; i >= 0; i--) {
            if (list[dependencies[i][0]].len > list[dependencies[i][1]].next.len) {
                list[dependencies[i][1]].next = list[dependencies[i][0]];
            }
        }
        for (int i = dependencies.length-1; i >= 0; i--) {
            list[dependencies[i][1]].len = Math.max(list[dependencies[i][1]].len, 1 + list[dependencies[i][0]].len);
        }
        for (int i = 1; i <= n; i++) {
            LinkNode node = list[i];
            if (!levelMap.containsKey(node.len)) {
                levelMap.put(node.len, new ArrayList<>());
            }
            levelMap.get(node.len).add(node);
        }
        boolean[] arr = new boolean[n + 1];
        int res = 0;
        for (int i = 1; i <= levelMap.size(); i++) {
            List<LinkNode> linkNodes = levelMap.get(i);
            int count = 0;
            for (LinkNode linkNode : linkNodes) {
                if (!arr[linkNode.val]) {
                    count++;
                    arr[linkNode.val] = true;
                }
            }
            res += count % k == 0 ? count / k : (count / k) + 1;
        }
        return res;
    }

    class LinkNode {
        public int val;
        public int len = 1;
        public LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }

    public TreeNode find(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        }
        if (root.children.isEmpty()) {
            return null;
        }
        if (root.children.keySet().contains(val)) {
            return root.children.get(val);
        }
        for (TreeNode node : root.children.values()) {
            find(node, val);
        }
        return null;
    }

    class TreeNode {
        public int val;
        public int level = 1;
        public Map<Integer, TreeNode> children = new HashMap<>();

        public TreeNode(int x) {
            val = x;
        }

        public Map<Integer, TreeNode> getChildren() {
            return children;
        }

        public void addChild(TreeNode node) {
            this.level = Math.max(level, node.level + 1);
            this.children.put(node.val, node);
        }
    }

    public int minNumberOfSemesters2(int n, int[][] dependencies, int k) {
        Set<Integer>[] adj = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new HashSet<>();
        }
        int[] outs = new int[n + 1], ins = new int[n + 1];
        for (int[] d : dependencies) {
            int from = d[0], to = d[1];
            adj[from].add(to);
            outs[from]++;
            ins[to]++;
        }

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> outs[b] - outs[a]);
        for (int i = 1; i <= n; i++) {
            if (ins[i] == 0) queue.add(i);
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            Set<Integer> set = new HashSet<>();
            int rest = k;
            while (!queue.isEmpty() && rest > 0) {
                rest--;
                int from = queue.remove();
                for (int to : adj[from]) {
                    ins[to]--;
                    if (ins[to] == 0) set.add(to);
                }
            }

            set.addAll(queue);

            queue = new PriorityQueue<>((a, b) -> outs[b] - outs[a]);
            queue.addAll(set);
        }
        return cnt;
    }

    public static void main(String[] args) {
        ProblemWeek20200627 p = new ProblemWeek20200627();
        int r = p.minNumberOfSemesters(5, new int[][]{{3, 4}, {1, 5}, {4, 2}, {2, 5}, {4, 5}, {1, 2}, {1, 4}, {3, 1}, {3, 2}, {3, 5}}, 3);
        System.out.println(r);
    }


}