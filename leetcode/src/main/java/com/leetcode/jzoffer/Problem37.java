package com.leetcode.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apa7 on 2020/6/5.
 */
public class Problem37 {

    Codec codec = new Codec();

    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            //StringBuilder sb = new StringBuilder("[");
            List<Integer> list = new ArrayList<>();
            List<TreeNode> children = new ArrayList<TreeNode>() {{
                add(root);
            }};
            while (!children.isEmpty()) {
                try {
                    for (TreeNode child : children) {
                        list.add(child == null ? null : child.val);
                        //sb.append(",");
                    }
                    children = findChildren(children);
                } catch (Exception e) {
                    break;
                }
            }
            int end = list.size() - 1;
            for (; end >= 0; end--) {
                if (list.get(end) != null) {
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i <= end; i++) {
                sb.append(list.get(i));
                if (i != end) {
                    sb.append(",");
                }
            }
            sb.append("]");
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if (!data.endsWith("]") || !data.startsWith("[")) {
                return null;
            }
            String[] arr = data.substring(1, data.length() - 1).split(",");
            if (arr.length == 0 || arr[0] == null) {
                return null;
            }
            TreeNode root = new TreeNode(new Integer(arr[0]));
            List<TreeNode> list = new ArrayList<TreeNode>() {{
                add(root);
            }};
            int i = 1;
            while (i < arr.length) {
                List<TreeNode> children = new ArrayList<>();
                for (TreeNode child : list) {
                    if (child == null) {
                        i += 2;
                        continue;
                    }
                    if (i < arr.length) {
                        String s = arr[i++];
                        if (s != null && !s.equals("null")) {
                            child.left = new TreeNode(new Integer(s));
                        }
                        children.add(child.left);
                    }
                    if (i < arr.length) {
                        String s = arr[i++];
                        if (s != null && !s.equals("null")) {
                            child.right = new TreeNode(new Integer(s));
                        }
                        children.add(child.right);
                    }
                }
                list = children;
            }
            return root;
        }

        private List<TreeNode> findChildren(List<TreeNode> parent) {
            List<TreeNode> list = new ArrayList<>();
            boolean allnull = true;
            for (TreeNode child : parent) {
                if (child != null) {
                    list.add(child.left);
                    list.add(child.right);
                    allnull = allnull && child.left == null && child.right == null;
                } else {
                    list.add(null);
                    list.add(null);
                }
            }
            return allnull ? new ArrayList<>() : list;
        }
    }

    public void sria() {
        TreeNode root = new TreeNode(1);
        root.setLR(2, null);
        root.left.setLR(null, null);
        root.right.setLR(4, 5);
        String serialize = codec.serialize(root);
        System.out.println(serialize);
    }

    public void desria() {
        TreeNode root = codec.deserialize("[1,2,3,null,null,4,5]");
        System.out.println(root);
    }

    public static void main(String[] args) {
        Problem37 p = new Problem37();
        p.sria();
        p.desria();
    }
}