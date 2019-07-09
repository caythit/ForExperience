package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实现描述：Design and implement a data structure for Least Recently Used (LRU) problem146.
 * It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the problem146, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the problem146 reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The problem146 is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUproblem146 problem146 = new LRUproblem146( 2  );
 * <p>
 * problem146.put(1, 1);
 * problem146.put(2, 2);
 * problem146.get(1);       // returns 1
 * problem146.put(3, 3);    // evicts key 2
 * problem146.get(2);       // returns -1 (not found)
 * problem146.put(4, 4);    // evicts key 1
 * problem146.get(1);       // returns -1 (not found)
 * problem146.get(3);       // returns 3
 * problem146.get(4);       // returns 4
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/8
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem146 {
    private Map<Integer, Integer> kv;
    private List<Integer> keyList;
    private Integer total;

    public Problem146(int capacity) {
        kv = new ConcurrentHashMap<>(capacity);
        keyList = new LinkedList<>();
        total = capacity;
    }

    public int get(int key) {
        Integer v = kv.get(key);
        if (v == null) {
            return -1;
        }
        // 重新摘除 再放入链尾
        keyList.remove(Integer.valueOf(key));
        keyList.add(key);
        return v;
    }


    public void put(int key, int value) {
        // 已经包含该key
        if (kv.get(key) != null) {
            kv.put(key, value);

            // 重新摘除 再放入链尾
            keyList.remove(Integer.valueOf(key));
            keyList.add(key);
            return;
        }

        // 不超过长度
        if (kv.size() < total) {
            // 直接放入链尾
            keyList.add(key);
            kv.put(key, value);
            return;
        }

        // 超过长度
        kv.remove(keyList.get(0));
        kv.put(key, value);
        // 摘除表头,放入链尾
        keyList.remove(0);
        keyList.add(key);
        return;
    }

    public static void main(String[] args) {
        Problem146 problem146 = new Problem146(1);
        problem146.put(2, 1);
        System.out.println(problem146.get(2));
        problem146.put(3, 2);
        System.out.println(problem146.get(2));
        System.out.println(problem146.get(3));
        System.out.println(problem146.get(4));
    }
}
