package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by apa7 on 2020/6/21.
 */
public class ProblemWeek20200621 {

    public int xorOperation(int n, int start) {
        Integer ret = start;
        for (int i = start + 2; i < start + n * 2; i += 2) {
            ret ^= i;
        }
        return ret;
    }

    Map<String, Integer> map;

    public String[] getFolderNames(String[] names) {
        String[] ret = names;
        map = new HashMap<>(names.length);
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (map.containsKey(name)) {
                Integer count = map.get(name) + 1;
                ret[i] = name + "(" + count + ")";
            } else {
                map.put(name, 0);
            }
        }
        return ret;
    }

    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> map = new HashMap<>();   //<rain,最新rain所在下标(上一次下雨下标)>
        List<Integer> list = new ArrayList<>(); //<抽水下标>，rain=0，抽水下标一定大于 最新rain所在下标(上一次下雨的下标)
        for (int i = 0; i < rains.length; i++) {
            int rain = rains[i];
            if (rain <= 0) {
                //当前下标可抽水
                list.add(i);
            } else {
                if (!map.containsKey(rain)) {
                    //第一次进来，直接下雨
                    map.put(rain, i);
                    rains[i] = -1;
                } else {
                    int idx = 0;
                    while (idx < list.size() && list.get(idx) < map.get(rain)) {
                        idx++;
                    }
                    //找不到可抽水的下标，抽不了水，就下不了雨，例如[2,3,0,0,3,1,0,1,0,2,2], 最后2,2的时候就不能抽水
                    if (idx >= list.size()) {
                        return new int[]{};
                    }
                    rains[list.remove(idx)] = rain;
                    rains[i] = -1;
                    map.put(rain, i);
                }
            }
        }
        //处理没有抽水的下标
        for (Integer i : list) {
            rains[i] = 1;
        }
        return rains;
    }

    private void test() {
//        xorOperation(4, 3);
//        int[] r = avoidFlood(new int[]{2, 3, 0, 0, 3, 1, 0, 1, 0, 2, 2});
//        System.out.println(r);
    }



    public static void main(String[] args) {
        ProblemWeek20200621 p = new ProblemWeek20200621();
        p.test();

//        输入：
//[1,0,2,3,0,1,2]
//        输出：
//[-1,2,-1,-1,1,-1,-1]
//        预期：
//[-1,1,-1,-1,2,-1,-1]


//[1,0,2,0,2,1]
//        输出：
//[-1,2,-1,1,-1,-1]
//        预期：
//[-1,1,-1,2,-1,-1]
    }
}