package com.mdx.experiance.struct;

/**
 * 实现描述：
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/18
 */
public class SingletonV1 {
    private static SingletonV1 singletonV1;

    private SingletonV1() {

    }

    public static SingletonV1 newInstance() {
        if(singletonV1 == null) {
            singletonV1 = new SingletonV1();
        }
        return singletonV1;
    }
}
