package com.windern.algorithmlearning.mooc.array;

import java.util.Arrays;

/**
 * 27 移除元素
 *
 * @author windern
 * @date 2020/11/21 17:39
 **/
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        // [0,k)存储非val的数据
        // [k,nums)存储val的数据
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 5, 1};
        int result = removeElement(nums, 1);
        System.out.println("result: " + result);
        System.out.println(Arrays.toString(nums));
    }
}
