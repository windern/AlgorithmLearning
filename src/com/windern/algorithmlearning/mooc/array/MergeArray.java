package com.windern.algorithmlearning.mooc.array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * @author windern
 * @date 2020/11/21 19:29
 **/
public class MergeArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // num1的当前位置
        int j1 = 0;
        // num2的当前位置
        int j2 = 0;

        int[] num3 = new int[m + n];
        for (int i = 0; i < num3.length; i++) {
            if (j1 >= m) {
                num3[i] = nums2[j2++];
            } else if (j2 >= n) {
                num3[i] = nums1[j1++];
            } else {
                if (nums2[j2] < nums1[j1]) {
                    num3[i] = nums2[j2++];
                } else {
                    num3[i] = nums1[j1++];
                }
            }
        }

        for (int i = 0; i < num3.length; i++) {
            nums1[i] = num3[i];
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }
}
