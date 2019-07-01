package com.mdx.experiance.thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现描述：
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/25
 */
public class NumberPrinter {

    private static ExecutorService executorService =
            new ThreadPoolExecutor(2, 2, 0, TimeUnit.MINUTES, new LinkedBlockingDeque<>());
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();


    class Number implements Runnable {

        private Integer v;

        public Number(Integer v) {
            this.v = v;
        }

        @Override
        public void run() {
            try {
                for (int i = v; i < 100; i += 2) {
                    lock.lock();
                    condition.signal();
                    System.out.println(i);
                    condition.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        Number odd = printer.new Number(0);
        Number even = printer.new Number(1);
        executorService.submit(odd);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.submit(even);
    }
}
