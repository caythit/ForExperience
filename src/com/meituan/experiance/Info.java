package com.meituan.experiance;

import java.lang.annotation.*;

/**
 * 实现描述：描述信息注解
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/5/30
 */
@Target({ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Info {
    StatusEnum status();
}
