package com.mdx.experiance.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现描述：
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/21
 */
public class ListArrayUtils {

    /**
     * 基础数据类型数组转list
     *
     * @param arrays
     * @return
     */
    public static List<Integer> basicTypeArray2List(int[] arrays) {
        return Arrays.stream(arrays).boxed().collect(Collectors.toList());
    }

    /**
     * 数组转list
     *
     * @param arrays
     * @return
     */
    public static List<Integer> array2List(Integer[] arrays) {
        return Arrays.asList(arrays);
    }

    /**
     * list转基础数据类型数组
     *
     * @param list
     * @return
     */
    public static int[] list2BasicTypeArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * list转数组
     *
     * @param list
     * @return
     */
    public static Integer[] list2Array(List<Integer> list) {
        return list.toArray(new Integer[list.size()]);
    }
}
