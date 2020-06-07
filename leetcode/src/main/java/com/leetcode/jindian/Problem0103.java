package com.leetcode.jindian;

/**
 * Created by apa7 on 2020/6/7.
 */
public class Problem0103 {

    public String replaceSpaces(String S, int length) {
        char[] arr = S.toCharArray();
        int idx = S.length() - 1;
        for(int i = length-1; i >= 0; i--){
            if(arr[i] == ' '){
                arr[idx--] = '0';
                arr[idx--] = '2';
                arr[idx--] = '%';
            } else{
                arr[idx--] = arr[i];
            }
        }
        return new String(arr, idx+1, arr.length-idx-1);
    }

    public static void main(String[] args) {
        String r = new Problem0103().replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27);
        System.out.println(r);
    }

}
