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
public class OddEvenPrinter {

    private static ExecutorService executorService =
            new ThreadPoolExecutor(2, 2, 0, TimeUnit.MINUTES, new LinkedBlockingDeque<>());
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();
    static CountDownLatch cdl = new CountDownLatch(2);

    class Odd implements Runnable {
        @Override
        public void run() {
            try {

                    for (int i = 0; i < 100; i += 2) {
                        lock.lock();
                        condition.signal();
                        System.out.println(i);
                        condition.await();
                    }


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                cdl.countDown();
            }
        }
    }

    class Even implements Runnable {
        @Override
        public void run() {
            try {

                    for (int i = 1; i < 100; i += 2) {
                        Thread.sleep(10);
                        lock.lock();
                        condition.signal();
                        System.out.println(i);
                        condition.await();
                    }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                cdl.countDown();
            }
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter();
        Odd odd = printer.new Odd();
        Even even = printer.new Even();

        executorService.submit(odd);
        executorService.submit(even);


        try {
            executorService.isTerminated();
        } catch (Exception e) {

        }
    }
}
