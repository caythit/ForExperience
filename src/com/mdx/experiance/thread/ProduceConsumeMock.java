package com.mdx.experiance.thread;

import java.util.LinkedList;
import java.util.Queue;
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
public class ProduceConsumeMock {

    private static ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MINUTES, new LinkedBlockingDeque<>());
    private Lock lock = new ReentrantLock();
    private Condition fullCond = lock.newCondition();
    private Condition emptyCond = lock.newCondition();
    private Queue<String> buffer = new LinkedList<>();
    static Integer size = 5;

    class Produce implements Runnable {
        private String name;

        public Produce(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    if (buffer.size() == size) {
                        System.out.println("警告：线程(" + Thread.currentThread().getName() + ")准备生产产品，但队列已满");
                        try {
                            fullCond.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    buffer.add("prod:" + name);
                    System.out.println("线程(" + Thread.currentThread().getName() + ")生产了一件产品:" + name + ";当前剩余商品" + buffer.size() + "个");
                    emptyCond.signal();
                } finally {
                    lock.unlock();
                }
                try {
                    // 让别的生产者/消费者也有机会拿到锁 不能放释放锁的上面 要不就一直是这个生产者生产了
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consume implements Runnable {
        private String name;

        public Consume(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    if (buffer.isEmpty()) {
                        System.out.println("警告：线程(" + Thread.currentThread().getName() + ")准备消费产品，但当前没有产品");
                        try {
                            emptyCond.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer.poll();
                    System.out.println("线程(" + Thread.currentThread().getName() + ")消费了一件产品:" + name + ";当前剩余商品" + buffer.size() + "个");
                    fullCond.signal();
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumeMock mock = new ProduceConsumeMock();
        for (int i = 0; i < 2; i++) {
            executorService.submit(mock.new Produce("producer" + i));
        }
        for (int i = 0; i < 4; i++) {
            executorService.submit(mock.new Consume("consumer" + i));
        }
    }
}
