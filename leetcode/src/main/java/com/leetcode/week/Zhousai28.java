package com.leetcode.week;

import java.util.*;

/**
 * Created by apa7 on 2020/6/7.
 */
public class Zhousai28 {

    class BrowserHistory {

        LinkedList<String> list = new LinkedList<>();
        volatile int current = 0;

        public BrowserHistory(String homepage) {
            list.push(homepage);
            current = 0;
        }

        public void visit(String url) {
            if (current > 0) {
                for (int i = 0; i < current; i++) {
                    try {
                        list.removeFirst();
                    } catch (Exception e) {
                        break;
                    }
                }
            }
            current=0;
            list.push(url);
        }

        public String back(int steps) {
            current += steps;
            if (current >= list.size()) {
                current = list.size() - 1;
            }
            return list.get(current);
        }

        public String forward(int steps) {
            current -= steps;
            if (current <= 0) {
                current = 0;
            }
            return list.get(current);
        }
    }


    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int len = arr.length;
        double m = arr[(len - 1) / 2];
//        if (len % 2 == 0) {
//            //偶数个
//            m = Double.valueOf(arr[(len - 1) / 2] + arr[(len / 2)]).doubleValue() / 2;
//        }
        double[] strong = new double[len];
        for (int i = 0; i < len; i++) {
            strong[i] = Math.abs(arr[i] - m);
        }
        int[] r = new int[k];
        int count = 0;
        int left = 0;
        int right = len - 1;
        while (count < k && left < right) {
            while (count < k && left < right && strong[left] > strong[right]) {
                r[count++] = arr[left++];
            }
            while (count < k && left < right && strong[right] > strong[left]) {
                r[count++] = arr[right--];
            }
            if (count < k && left < right && strong[right] == strong[left]) {
                if (arr[left] > arr[right]) {
                    r[count++] = arr[left++];
                    //r[count++]
                } else {
                    r[count++] = arr[right--];
                }
            }
        }
        if (k == len) {
            r[k - 1] = arr[right];
        }
        return r;
    }

    public void test() {
//        int[] arr = new int[]{-7, 22, 17, 3};
//        int[] strongest = getStrongest(arr, 2);
//        System.out.println(strongest);

        BrowserHistory history = new BrowserHistory("jrbilt");
        history.visit("uiza");

//        ["BrowserHistory","visit","forward","forward","visit","visit","back","visit","visit","forward","back","visit","visit","visit","forward","forward","visit","visit","back","visit","forward","visit","visit","visit","back"]
//[["jrbilt.com"],["uiza.com"],[3],[3],["fveyl.com"],["hyhqfqf.com"],[3],["cccs.com"],["bivz.com"],[6],[1],["cmbw.com"],["iywwwfn.com"],["sktbhdx.com"],[8],[10],["bskj.com"],["thw.com"],[6],["hgesj.com"],[6],["ctb.com"],["fllnc.com"],["fs.com"],[7]]
    }

    public static void main(String[] args) {
        Zhousai28 p = new Zhousai28();
        p.test();
    }
}