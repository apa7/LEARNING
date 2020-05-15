package com.leetcode.base;


/**
 * 冒泡
 * Created by apa7 on 2020/5/15.
 */
public class Base1 {

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,2,7,9,6,2};
        Base1 p = new Base1();
        int[] sort = p.sort(arr);
        System.out.println(sort);
    }
}