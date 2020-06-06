package com.leetcode.problems;

/**
 * Created by apa7 on 2020/6/6.
 */
public class Problem42 {

    public int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        //先递减再递增，才能接得住雨水。
        //要求这个队列头为接水容器的左边缘，尾为容器右边缘。
        //有几种情况：
        // 1.右边缘>左边缘,取左边缘。一个接水容器完成。
        // 2.右边缘=左边缘。一个接水容器完成。
        // 3.右边缘<左边缘，一直取完height[], 左边都是最大的。
        // 3这是最复杂的情况，应该去掉队首，重新从这个队列中寻找容器。
        //LinkedList<Integer> stack = new LinkedList<>();
        //stack.push(height[0]);
        //容器数组，[[leftIndex,rightIndex,maxHeight]]
        int[][] collections = new int[height.length / 3][3];
        //List<Stack<Integer>> stackList = new ArrayList<>();
        int maxHeight = 0;
        int[] col = new int[3];
        for (int i = 0; i < height.length; i++) {
            col[0] = i;
            if (height[i] >= col[0]) {
                col[0] = i;
            }
            if (i == height.length - 1) {
                //TODO最终节点，还没取完.情况3.
            }
        }

        //TODO 未完成
        return 0;
    }

    public static void main(String[] args) {
        Problem42 p = new Problem42();
        int r = p.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(r);
    }

}