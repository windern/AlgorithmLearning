package com.windern.algorithmlearning.mooc.array;

/**
 * 80 删除排序数组中的重复项 II
 *
 * @author windern
 * @date 2020/11/21 18:27
 **/
public class RemoveDuplicates2 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // [0,k]存储的有效元素
        int k = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[k]) {
                boolean canPut = canPut(nums, k);
                if (canPut) {
                    // 如果可以继续放
                    k++;
                    nums[k] = nums[i];
                }
            } else {
                // 不相等肯定可以继续放
                k++;
                nums[k] = nums[i];
            }
        }

        return k + 1;
    }

    /**
     * 是否能继续放入
     *
     * @param nums 数组
     * @param k 存的最后一个元素的位置
     * @return 是否可以放入
     */
    private static boolean canPut(int[] nums, int k) {
        if (k == 0) {
            return true;
        } else {
            // 不相等可以放true，相等有两个元素了，不能放了false
            return nums[k - 1] != nums[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int result = removeDuplicates(nums);
        System.out.println(result);
    }
}
