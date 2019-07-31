package com.mdx.experiance.struct;

import java.util.stream.IntStream;

/**
 * 实现描述：
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/30
 */
public class CalcMain {
    public static void main(String[] args) {
        int[] arrays = IntStream.rangeClosed(0, 1000000).toArray();

        CalcService calcService = new ForkJoinCalcServiceImpl();

        Long start = System.currentTimeMillis();
        Long sum = calcService.sumArray(arrays);
        Long end = System.currentTimeMillis();
        System.out.println(sum + ":" + (end - start));

    }
}


