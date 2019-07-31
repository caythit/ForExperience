package com.mdx.experiance.struct;

/**
 * 实现描述：插入排序
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/24
 */
public class SortUtil {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 3, 1, 8, 7, 2, 4};
//        intesectionSort(nums);
//        for (int i : nums) {
//            System.out.println(i);
//        }
        quickSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] nums) {
        quickSort(0, nums.length - 1, nums);

    }


    private static void quickSort(int i, int j, int[] nums) {
        if (i > j) {
            return;
        }
        int sb = nums[i];
        int sbI = i;
        while (i < j) {
            while (nums[j] >= sb && i < j) {
                j--;
            }
            while (nums[i] <= sb && i < j) {
                i++;
            }
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }

        }
        nums[sbI] = nums[i];
        nums[i] = sb;
        quickSort(sbI, i - 1, nums);
        quickSort(j + 1, nums.length - 1, nums);
    }

    private static void intesectionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }


}
