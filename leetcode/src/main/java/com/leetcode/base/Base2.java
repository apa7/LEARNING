package com.leetcode.base;

/**
 * 插入排序
 * Created by apa7 on 2020/5/15.
 */
public class Base2 {

    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int index = i - 1;
            while (index >= 0 && insertValue < arr[index]) {
                // 当遇到大于当前的数，就那个数往右一个。
                arr[index + 1] = arr[index];
                //往前移动
                index--;
            }
            arr[index + 1] = insertValue;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 7, 9, 6, 2};
        Base1 p = new Base1();
        int[] sort = p.sort(arr);
        System.out.println(sort);
    }

}