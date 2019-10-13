package com.windern.algorithmlearning.GeekTimeWangZheng.g16_binarysearch;

public class FirstEqualBSearch {

    public static int bsearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 5, 5, 9, 9};
        int value = 10;
        int result = bsearch(a, value);
        System.out.println(result);
    }
}
