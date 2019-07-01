package com.mdx.experiance.other;

/**
 * 实现描述：
 * 顺序数组 从某个位置拦断 将其后的元素平移到数组开头
 * 比如 1234567 -》 5671234
 * 找出平移后数组的最小值，要求时间复杂度O(logN)
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/1
 */
public class FB1 {

    private Integer findMin(Integer a[]) {
        return findMin(0, a.length, a);
    }

    /**
     * @param start
     * @param end
     * @param a
     * @return
     */
    private Integer findMin(int start, int end, Integer[] a) {
        int mid = (start + end) / 2;
        if(a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
            return a[mid];
        }

        if (a[mid] > a[start]) {
            return findMin(mid, end, a);
        }
        return findMin(start, mid, a);
    }

    public static void main(String[] args) {
        FB1 fb1 = new FB1();
        System.out.println(fb1.findMin(new Integer[]{5, 6, 7, 8, 1, 2, 3, 4}));
        System.out.println(fb1.findMin(new Integer[]{5, 6, 7, 1, 2, 3, 4}));
        System.out.println(fb1.findMin(new Integer[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
