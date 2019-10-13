package com.windern.algorithmlearning.GeekTimeWangZheng.g16_binarysearch;

import java.util.Arrays;

public class LoopFindSmall {

    public static int findLoopStart(int[] a) {
        int low = 0;
        int high = a.length - 1;
        if (a[low] < a[high]) {
            return low;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > a[mid + 1]) {
                return mid + 1;
            }
            if (a[mid - 1] > a[mid]) {
                return mid;
            }
            if (a[mid] > a[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 1, 2, 3};
        System.out.println(Arrays.toString(a) + "---start index--->" + findLoopStart(a));
        int[] b = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(b) + "---start index--->" + findLoopStart(b));
        int[] c = {2, 3, 4, 5, 6, 1};
        System.out.println(Arrays.toString(c) + "---start index--->" + findLoopStart(c));
    }
}
