package com.windern.algorithmlearning.GeekTimeWangZheng.g16_binarysearch;

import java.util.Arrays;

public class LoopBSearch {

    public static int bsearch(int[] a, int value) {


        return -1;
    }

    public static int findLoopStart(int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= 0 || mid >= a.length - 1) {
                if (mid <= 0) {
                    if (a[mid] < a[mid + 1]) {
                        return mid;
                    } else {
                        return mid + 1;
                    }
                } else {
                    if (a[mid - 1] > a[mid]) {
                        return mid;
                    } else {
                        return mid - 1;
                    }
                }
            } else {
                if (a[mid - 1] > a[mid] && a[mid] < a[mid + 1]) {
                    return mid;
                } else if (a[mid - 1] < a[mid] && a[mid] < a[mid + 1]) {
                    high = mid - 1;
                } else if (a[mid - 1] > a[mid] && a[mid] > a[mid + 1]) {
                    low = mid + 1;
                } else {
                    return mid + 1;
                }
            }
        }

        if (high <= 0) {
            return 0;
        }
        if (low >= a.length - 1) {
            return a.length - 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        testFindLoopStart();

//        int[] a = {4, 5, 6, 1, 2, 3};
//        System.out.println(bsearch(a, 0));
//        System.out.println(bsearch(a, 2));
//        System.out.println(bsearch(a, 5));
//        System.out.println(bsearch(a, 7));
    }

    public static void testFindLoopStart() {
        int[] a = {4, 5, 6, 1, 2, 3};
        System.out.println(Arrays.toString(a) + "---start index--->" + findLoopStart(a));
        int[] b = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(b) + "---start index--->" + findLoopStart(b));
        int[] c = {2, 3, 4, 5, 6, 1};
        System.out.println(Arrays.toString(c) + "---start index--->" + findLoopStart(c));
    }
}
