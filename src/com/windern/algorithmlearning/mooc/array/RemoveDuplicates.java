package com.windern.algorithmlearning.mooc.array;

/**
 * 26 删除排序数组中的重复项
 *
 * @author windern
 * @date 2020/11/21 18:14
 **/
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // [0,k]存储没有重复的元素，0肯定是不重复的
        int k = 0;

        for (int i = 1; i < nums.length; i++) {
            boolean isExist = false;
            // [0,k]存储的，所以是<=
            for (int j = 0; j <= k; j++) {
                if (nums[i] == nums[j]) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                k++;
                nums[k] = nums[i];
            }
        }

        return k + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 2};
        int result = removeDuplicates(nums);
        System.out.println(result);
    }
}
