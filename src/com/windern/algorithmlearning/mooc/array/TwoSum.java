package com.windern.algorithmlearning.mooc.array;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * @author windern
 * @date 2020/11/21 21:29
 **/
public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        // 循环 + 二分查找
        for (int i = 0; i < numbers.length; i++) {
            int l = i + 1;
            int r = numbers.length - 1;
            int findOtherValue = target - numbers[i];
            int otherIndex = binarySearch(numbers, findOtherValue, l, r);
            if (otherIndex != -1) {
                int[] result = new int[2];
                result[0] = i + 1;
                result[1] = otherIndex + 1;
                return result;
            }
        }

        return new int[0];
    }

    public static int binarySearch(int[] nums, int target, int l, int r) {
        // [nl,nr]中寻找指定的值target
        int nl = l;
        int nr = r;
        while (nl <= nr) {
            int mid = nl + (nr - nl) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                nl = mid + 1;
            } else {
                nr = mid - 1;
            }
        }

        return -1;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        // 对撞指针
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                int[] result = new int[2];
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum2(nums, 9);
        System.out.println(Arrays.toString(result));
    }
}
