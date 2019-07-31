package com.mdx.experiance.struct;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 实现描述：
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/30
 */
public class ForkJoinCalcServiceImpl implements CalcService {

    private ForkJoinPool forkJoinPool;

    public ForkJoinCalcServiceImpl() {
        forkJoinPool = ForkJoinPool.commonPool();
    }

    @Override
    public Long sumArray(int[] arrays) {
        return forkJoinPool.invoke(new SubTaskFork(0, arrays.length - 1, arrays));
    }
}

class SubTaskFork extends RecursiveTask<Long> {

    private static final Integer threshold = 10;
    private Integer from;
    private Integer to;
    private int[] arrays;

    public SubTaskFork(Integer from, Integer to, int[] arrays) {
        this.from = from;
        this.to = to;
        this.arrays = arrays;
    }

    @Override
    protected Long compute() {
        if (to - from <= threshold) {
            Long total = 0L;
            for (int i = from; i <= to; i++) {
                total += arrays[i];
            }
            return total;
        } else {
            int mid = (from + to) / 2;

            SubTaskFork leftSubTask = new SubTaskFork(from, mid, arrays);
            SubTaskFork rightSubTask = new SubTaskFork(mid + 1, to, arrays);
            leftSubTask.fork();
            rightSubTask.fork();
            return leftSubTask.join() + rightSubTask.join();
        }
    }
}
