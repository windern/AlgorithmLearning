package com.windern.algorithmlearning.Offer;

public class Offer11 {

    public int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int l = 0;
        int h = nums.length - 1;


        while (l < h) {
            // 开始就算mid
            int m = l + (h - l) / 2;

            if (nums[l] == nums[m] && nums[m] == nums[h]) {
                return minNumber(nums, l, h);
            } else if (nums[m] <= nums[h]) {
                h = m;
            } else {
                // 通过m+1，来使下标超过h
                l = m + 1;
            }
        }

        return nums[l];
    }

    private int minNumber(int[] nums, int l, int h) {
        for (int i = l; i <= h; i++) {
            if (nums[l] > nums[i]) {
                return nums[i];
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1};

        Offer11 offer11 = new Offer11();
        int min = offer11.minNumberInRotateArray(nums);
        System.out.println(min);
    }
}
