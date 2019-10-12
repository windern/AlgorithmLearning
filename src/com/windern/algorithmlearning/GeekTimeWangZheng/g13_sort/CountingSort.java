package com.windern.algorithmlearning.GeekTimeWangZheng.g13_sort;

import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] a) {
        if (a.length <= 1) {
            return;
        }

        int[] r = new int[a.length];

        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        // 多生成1位，0-max
        int[] c = new int[max + 1];
        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] = c[i - 1] + c[i];
        }

        for (int i = a.length - 1; i >= 0; i--) {
            // index算的时候记得减1
            int index = c[a[i]] - 1;
            r[index] = a[i];
            // 使用掉之后记得减1
            c[a[i]]--;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 3, 0, 2, 3, 0, 3};
        countingSort(a);
        System.out.println(Arrays.toString(a));
    }

}
