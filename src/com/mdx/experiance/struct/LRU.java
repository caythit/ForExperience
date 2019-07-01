package com.mdx.experiance.struct;

import java.util.*;

/**
 * 实现描述：LRU算法，保证put、get操作O(1)复杂度 且只能用哈希表和链表结构
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/30
 */
public class LRU {
    private Integer maxSize;
    private Map<String, String> map;

    private List<String> list;

    public LRU(Integer maxSize) {
        map = new HashMap<>();
        list = new LinkedList<>();
        this.maxSize = maxSize;
    }

    /**
     * 每次放入 链表尾部
     *
     * @param key
     * @param value
     * @return
     */
    public void put(String key, String value) {
        if (list.size() < maxSize) {
            list.add(value);
            map.put(key, value);
            return;
        }
        removeAndPut(key, value);
    }

    /**
     * 移除并放入新元素
     *
     * @param key
     * @param value
     */
    private void removeAndPut(String key, String value) {
        String oldKey = list.remove(0);
        map.remove(oldKey);

        list.add(key);
        map.put(key, value);
    }

    /**
     * 每次取完 挂到链表尾部
     *
     * @param key
     * @return
     */
    public String get(String key) {
        String value = map.get(key);
        updateLRU(key);
        return value;
    }

    /**
     * 更新元素
     *
     * @param key
     */
    private void updateLRU(String key) {
        list.remove(key);
        list.add(key);
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put("1", "1");
        lru.put("2", "2");
        lru.put("3", "3");
        lru.get("1");
        lru.put("4", "4");
        lru.put("5", "5");

        for(Map.Entry entry : lru.map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
