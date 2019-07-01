package com.mdx.experiance.struct;

/**
 * 实现描述：
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/18
 */
public class ThreadSafeSingletonV2 {
    private ThreadSafeSingletonV2() {

    }

    // 静态内部类只有被调用的时候才被首次加载
    private static class ThreadSafeSingletonV2Builder {
        private static ThreadSafeSingletonV2 threadSafeSingletonV2 = new ThreadSafeSingletonV2();
    }

    public static ThreadSafeSingletonV2 newInstance() {
        return ThreadSafeSingletonV2Builder.threadSafeSingletonV2;
    }
}
