package com.windern.algorithmlearning.mooc.array;

import java.util.Arrays;

/**
 * @author windern
 * @date 2020/11/21 17:10
 **/
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        // [0,k)的元素均为非0元素
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        // [k,nums)为0
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeroes2(int[] nums) {
        // [0,k)的元素均为非0元素
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, k);
                k++;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 5, 12, 0};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
