package com.windern.algorithmlearning.mooc.array;

/**
 * 209 长度最小的子数组
 *
 * @author windern
 * @date 2020/11/21 23:11
 **/
public class MinSubArrayLen {

    public static int minSubArrayLen(int s, int[] nums) {
        // nums[l,r]为我们的滑动窗口
        int l = 0;
        int r = -1;
        int res = nums.length + 1;
        int sum = 0;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                // 如果sum小，右边界需要前进，同时要保证右边界要能继续前进
                r++;
                sum += nums[r];
            } else {
                // i前移一位
                sum -= nums[l];
                l++;
            }

            if (sum >= s) {
                // 是一个解
                res = Math.min(res, r - l + 1);
            }
        }

        if (res == nums.length + 1) {
            return 0;
        }

        return res;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = minSubArrayLen(s, nums);
        // result = 2
        System.out.println(result);
    }
}
