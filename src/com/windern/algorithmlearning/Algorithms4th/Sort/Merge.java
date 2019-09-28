package com.windern.algorithmlearning.Algorithms4th.Sort;

public class Merge extends Example {

    private static Comparable[] aux;

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];

        sort(a, 0, a.length - 1);
    }

    public static void down2UpMergeSort(Comparable[] a) {
        aux = new Comparable[a.length];

        int n = a.length;
        // sz子数组的大小
        for (int sz = 1; sz < n; sz = sz + sz) {
            // lo子数组的索引
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz - 1 + sz, n - 1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = randomArray(100);

        show(array);
//        sort(array);
        down2UpMergeSort(array);
        System.out.println(isSorted(array));
        show(array);
    }
}
