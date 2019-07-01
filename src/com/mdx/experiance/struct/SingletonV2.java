package com.mdx.experiance.struct;

/**
 * 实现描述：
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/18
 */
public class SingletonV2 {
    private static SingletonV2 singletonV2 = new SingletonV2();

    private SingletonV2() {

    }

    public static SingletonV2 newInstance() {
        return singletonV2;
    }
}
