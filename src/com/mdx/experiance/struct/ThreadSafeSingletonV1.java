package com.mdx.experiance.struct;

/**
 * 实现描述：double-check
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/18
 */
public class ThreadSafeSingletonV1 {
    private static ThreadSafeSingletonV1 threadSafeSingletonV1;

    private ThreadSafeSingletonV1() {

    }

    public static ThreadSafeSingletonV1 newInstance() {
        if (threadSafeSingletonV1 == null) {
            synchronized (ThreadSafeSingletonV1.class) {
                if (threadSafeSingletonV1 == null) {
                    threadSafeSingletonV1 = new ThreadSafeSingletonV1();
                }
            }
        }
        return threadSafeSingletonV1;
    }
}
