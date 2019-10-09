package com.windern.algorithmlearning.GeekTimeWangZheng.g12_sort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class KthSmallest {

    public static int kthSamllest(int[] a, int k) {
        if (k > a.length) {
            return -1;
        }

        int kNum = findK(a, k, 0, a.length - 1);
        return kNum;
    }

    public static int findK(int[] a, int k, int p, int r) {
        int q = partion(a, p, r);
        System.out.println(Arrays.toString(a));

        if (q + 1 == k) {
            return a[q];
        } else if (q + 1 < k) {
            return findK(a, k, q + 1, r);
        } else {
            return findK(a, k, p, q - 1);
        }
    }

    public static int partion(int[] a, int p, int r) {
        if (p >= r) return p;

        int pivot = a[r];
        int i = p;
        for (int j = p; j <= r - 1; j++) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

    public static int[] randomArray(int n) {
        List<Integer> list = new Random().ints(0, n).distinct().limit(n).boxed().collect(Collectors.toList());
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = randomArray(10);
        System.out.println(Arrays.toString(array));
        int knum = kthSamllest(array, 4);
        System.out.println(Arrays.toString(array));
        System.out.println(knum);
    }
}
