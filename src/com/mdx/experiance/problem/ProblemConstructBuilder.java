package com.mdx.experiance.problem;

/**
 * 实现描述：
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/5/23
 */
public class ProblemConstructBuilder<T> {
    private T t;

    /**
     * 静态方法不可以访问类上定义的泛型
     *
     * @param <T>
     * @return
     */
    @Deprecated
    public static<T> ProblemConstructBuilder<T> newProblemConstructBuilder(String className) {
        return new ProblemConstructBuilder<T>(className);
    }

    public ProblemConstructBuilder(String className) {
        try {
            t = (T) Class.forName(className).newInstance();
        } catch (Exception e) {
        }
    }

    public T build() {
        return this.t;
    }
}
