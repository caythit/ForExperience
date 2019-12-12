package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;

import java.util.*;

/**
 * 实现描述：
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 * <p>
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * <p>
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * <p>
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * <p>
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * <p>
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * <p>
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * <p>
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/21
 */
@Info(status = StatusEnum.WRONG_ANSWER)
public class Problem380 {
    private Map<Integer, Integer> randomMap;
    private Deque<Integer> deque;

    /**
     * 共18个例子，通过17个
     */
    public Problem380() {
        randomMap = new HashMap<>();
        deque = new LinkedList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (randomMap.containsKey(val)) {
            return false;
        }
        randomMap.put(val, val);
        // 写入队尾
        deque.offerLast(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (randomMap.containsKey(val)) {
            randomMap.remove(val);
            deque.remove(val);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        // 从队首拿出再放入队尾
        Integer head = deque.pollFirst();
        deque.offerLast(head);
        return head;
    }

    public static void main(String[] args) {
        Problem380 problem = new Problem380();
        System.out.println(problem.remove(0));
        System.out.println(problem.remove(0));
        System.out.println(problem.insert(0));
        System.out.println(problem.getRandom());
        System.out.println(problem.remove(0));
        System.out.println(problem.insert(0));
        System.out.println(problem.insert(1));
        System.out.println(problem.insert(2));
        System.out.println(problem.getRandom());
        System.out.println(problem.getRandom());
        System.out.println(problem.getRandom());
        System.out.println(problem.getRandom());


    }
}
