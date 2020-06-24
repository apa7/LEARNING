package com.leetcode.jzoffer;

import java.util.Stack;

/**
 * Created by apa7 on 2020/6/22.
 */
public class Problem31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int loc = 0;
        for (Integer num : stack) {
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[loc]){
                stack.pop();
                loc++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Problem31 p = new Problem31();
        p.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{3,5,4,2,1});
    }
}