package com.leetcode.jzoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 * <p>
 * Created by apa7 on 2020/7/4.
 * TODO 经典位运算！重温
 */
public class Problem56 {

    //这样理解,这是相当于是三进制,one表示第一次出现,two表示第二次出现 第一次出现时 one = 1 two = 0 第二次出现时 one = 0 two = 1 第三次出现时 one = 0 two = 0 通过 one/two ^ num就可以将数据保留到相应的数字里(相当于置1), 而后面的 &~one/two意思是就是判断是否需要进位, 因为one = 1 two = 1 是表示 3 此时 one = 0 two = 0
    //a表示每一位余数是否为1，b表示每一位余数是否为2，二者不同时为真，根据num更新a和b。
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for(int num : nums){
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }
        return a;
    }

    public static void main(String[] args) {
        Problem56 p = new Problem56();
        int r = p.singleNumber(new int[]{3, 4, 3, 3});
        System.out.println(r);
    }

}
