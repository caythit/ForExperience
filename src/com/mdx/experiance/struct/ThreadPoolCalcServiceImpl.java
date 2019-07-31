package com.mdx.experiance.struct;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 实现描述：
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/30
 */
public class ThreadPoolCalcServiceImpl implements CalcService {

    private Integer poolSize;
    private ThreadPoolExecutor poolExecutor;

    public ThreadPoolCalcServiceImpl() {
        poolSize = Runtime.getRuntime().availableProcessors();
        poolExecutor = new ThreadPoolExecutor(poolSize, poolSize, 0L, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
    }

    @Override
    public Long sumArray(int[] arrays) {
        List<Future<Long>> resLists = new ArrayList<>();

        Integer batch = arrays.length / poolSize;
        for (int i = 0; i < poolSize; i++) {
            Integer from = i * batch;
            Integer to = i == poolSize - 1 ? arrays.length - 1 : ((i + 1) * batch - 1);
            resLists.add(poolExecutor.submit(new subTask(from, to, arrays)));
        }

        Long total = 0L;
        for (Future<Long> res : resLists) {
            try {
                total += res.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return total;
    }


}

class subTask implements Callable<Long> {

    private Integer from;
    private Integer to;
    private int[] arrays;

    public subTask(Integer from, Integer to, int[] arrays) {
        this.from = from;
        this.to = to;
        this.arrays = arrays;
    }

    @Override
    public Long call() {
        Long sum = 0L;

        for (int i = from; i <= to; i++) {
            sum += arrays[i];
        }
        return sum;
    }

}
