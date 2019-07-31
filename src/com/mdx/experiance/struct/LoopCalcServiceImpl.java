package com.mdx.experiance.struct;

/**
 * 实现描述：
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/30
 */
public class LoopCalcServiceImpl implements CalcService {
    @Override
    public Long sumArray(int[] arrays) {
        Long total = 0L;
        for (int i : arrays) {
            total += i;
        }
        return total;
    }
}
