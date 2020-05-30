package com.leetcode.problems;

import java.util.LinkedList;

/**
 * Created by apa7 on 2020/5/30.
 */
public class Problem146 {

class LRUCache {

    private int capacity;
    private LinkedList<Integer> deque = new LinkedList<>();
    private CacheMap map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new CacheMap(100);
    }

    public int get(Integer key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            //最近活跃，移动到队尾
            deque.remove(key);
            deque.addLast(key);
            return map.get(key);
        }
    }

    public void put(Integer key, int value) {
        if (map.containsKey(key)) {
            deque.remove(key);
            deque.addLast(key);
            map.put(key, value);
        } else {
            if (deque.size() >= capacity) {
                //队列满了，淘汰队首
                Integer lruKey = deque.removeFirst();
                map.remove(lruKey);
            }
            deque.addLast(key);
            map.put(key, value);
        }
    }
}

class CacheMap {

    int capacity;
    private Integer[] hashArr;

    public CacheMap(int capacity) {
        this.capacity = capacity;
        this.hashArr = new Integer[capacity];
    }

    public boolean containsKey(Integer key) {
        return hashArr[hashs(key)] != null;
    }

    public int get(Integer key) {
        Integer v = hashArr[hashs(key)];
        return v == null ? -1 : v;
    }

    public void put(Integer key, int value) {
        hashArr[hashs(key)] = value;
    }

    public void remove(Integer key) {
        hashArr[hashs(key)] = -1;
    }

    public int hashs(Integer key) {
        return key == null ? 0 : key.hashCode() & (capacity - 1);
    }
}

    public void execute() {
        Problem146 p = new Problem146();
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5, 5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));

//        ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
//[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
    }

    public static void main(String[] args) {
        Problem146 p = new Problem146();
        p.execute();
    }

}