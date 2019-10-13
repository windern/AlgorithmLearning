package com.windern.algorithmlearning.GeekTimeWangZheng.g15_binarysearch;

public class BinarySearch {

    public static int binarySearch(int[] a, int m) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == m) {
                return mid;
            } else if (a[mid] < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int search(int[] a, int m) {
        return searchRecursive(a, m, 0, a.length - 1);
    }

    public static int searchRecursive(int[] a, int m, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (a[mid] == m) {
            return mid;
        } else if (a[mid] < m) {
            return searchRecursive(a, m, mid + 1, high);
        } else {
            return searchRecursive(a, m, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 8, 9};
        int m = 8;
//        int i = binarySearch(a, m);
        int i = search(a, m);
        System.out.println(i);
    }
}
