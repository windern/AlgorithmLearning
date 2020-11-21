package com.windern.algorithmlearning.mooc.array;

import java.util.Arrays;

/**
 * 75. 颜色分类
 *
 * @author windern
 * @date 2020/11/21 18:51
 **/
public class SortColors {

    public static void sortColors(int[] nums) {
        // 计数排序的个数的数组
        int[] count = new int[3];
        Arrays.fill(count, 0);
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] = count[nums[i]] + 1;
        }

        int index = 0;
        for (int j = 0; j < count.length; j++) {
            for (int i = 0; i < count[j]; i++) {
                nums[index++] = j;
            }
        }
    }

    public static void sortColors2(int[] nums) {
        // [0, zero]存0的区间
        int zero = -1;
        // [two, nums -1]存2区间
        int two = nums.length;
        // [zero+1, i]存1区间
        for (int i = 0; i < two; ) {
            // 这个地方是i<two而不是nums.length，后面继续走逻辑有问题
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, two - 1);
                two--;
            } else {
                swap(nums, i, zero + 1);
                zero++;
                i++;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
