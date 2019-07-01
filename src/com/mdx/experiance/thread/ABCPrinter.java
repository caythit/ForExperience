package com.mdx.experiance.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
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
public class ABCPrinter {
    private static ExecutorService executorService =
            new ThreadPoolExecutor(3, 3, 0, TimeUnit.MINUTES, new LinkedBlockingDeque<>());
    final Lock lock = new ReentrantLock();
    final Condition conditionA = lock.newCondition();
    final Condition conditionB = lock.newCondition();
    final Condition conditionC = lock.newCondition();

    class A implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    lock.lock();
                    conditionA.signal();
                    System.out.println("A");
                    conditionC.await();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class B implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(10);
                    lock.lock();
                    conditionB.signal();
                    System.out.println("B");
                    conditionA.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class C implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(15);
                    lock.lock();
                    conditionC.signal();
                    System.out.println("C");
                    conditionB.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ABCPrinter printer = new ABCPrinter();
        ABCPrinter.A a = printer.new A();
        ABCPrinter.B b = printer.new B();
        ABCPrinter.C c = printer.new C();

        executorService.submit(a);
        executorService.submit(b);
        executorService.submit(c);

    }
}
