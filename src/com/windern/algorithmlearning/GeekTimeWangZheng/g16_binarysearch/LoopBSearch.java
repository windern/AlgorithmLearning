package com.windern.algorithmlearning.GeekTimeWangZheng.g16_binarysearch;

import java.util.Arrays;

public class LoopBSearch {

    public static int bsearch(int[] a, int value) {
        if (a[0] < a[a.length - 1]) {
            return bsearchStartEnd(a, value, 0, a.length - 1);
        } else {
            return bsearchLoopStartEnd(a, value, 0, a.length - 1);
        }
    }

    public static int bsearchLoopStartEnd(int[] a, int value, int low, int high) {
//        System.out.println("bsearchLoopStartEnd:low:" + low + ",high:" + high);

        if (low > high) {
            return -1;
        } else if (low == high) {
            if (a[low] == value) {
                return low;
            } else {
                return -1;
            }
        }
        // 有限排除low、high
        if (a[low] == value) {
            return low;
        }
        if (a[high] == value) {
            return high;
        }

        int mid = low + (high - low) / 2;
//        System.out.println("bsearchLoopStartEnd:mid:" + mid);
        if (a[mid] == value) {
            return mid;
        } else {
            if (a[low] < a[mid]) {
                // low-mid有序，mid-high循环
                if (a[low] < value && value < a[mid]) {
                    // 只有a[low]-value-a[mid]之间的才进行搜索，否则都到循环数组中搜索
                    return bsearchStartEnd(a, value, low, mid);
                } else {
                    return bsearchLoopStartEnd(a, value, mid, high);
                }
            } else {
                // low-mid循环，mid-high有序
                if (a[mid] < value && value <= a[high]) {
                    // 只有a[mid]-value-a[high]之间的才进行搜索，否则都到循环数组中搜索
                    return bsearchStartEnd(a, value, mid, high);
                } else {
                    return bsearchLoopStartEnd(a, value, low, mid);
                }
            }
        }
    }

    public static int bsearchStartEnd(int[] a, int value, int low, int high) {
//        System.out.println("bsearchLoopStartEnd:low:" + low + ",high:" + high);
        if (low > high) {
            return -1;
        } else if (low == high) {
            if (a[low] == value) {
                return low;
            } else {
                return -1;
            }
        }

        int mid = low + (high - low) / 2;
//        System.out.println("bsearchLoopStartEnd:mid:" + mid);
        if (a[mid] < value) {
            return bsearchStartEnd(a, value, mid + 1, high);
        } else if (a[mid] > value) {
            return bsearchStartEnd(a, value, low, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
//        int[] a = {4, 5, 6, 1, 2, 3};
//        int[] a = {1, 2, 3, 4, 5, 6};
        int[] a = {2, 3, 4, 5, 6, 1};
        System.out.println("0:" + bsearch(a, 0));
        System.out.println("1:" + bsearch(a, 1));
        System.out.println("2:" + bsearch(a, 2));
        System.out.println("3:" + bsearch(a, 3));
        System.out.println("4:" + bsearch(a, 4));
        System.out.println("5:" + bsearch(a, 5));
        System.out.println("6:" + bsearch(a, 6));
        System.out.println("7:" + bsearch(a, 7));
    }
}
