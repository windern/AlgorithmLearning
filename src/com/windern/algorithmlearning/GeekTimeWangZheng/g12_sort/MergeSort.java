package com.windern.algorithmlearning.GeekTimeWangZheng.g12_sort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSort {

    public static void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int l, int h) {
        if (l >= h) {
            return;
        }

        int mid = l + (h - l) / 2;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, h);
//        merge(array, l, mid, h);
        mergeBySentry(array, l, mid, h);
    }

    public static void merge(int[] array, int l, int m, int h) {
        int[] tmpArray = new int[array.length];

        int index = l;
        int i = l;
        int j = m + 1;
        while (index <= h) {
            if (i > m) {
                tmpArray[index++] = array[j++];
            } else if (j > h) {
                tmpArray[index++] = array[i++];
            } else if (array[i] <= array[j]) {
                tmpArray[index++] = array[i++];
            } else {
                tmpArray[index++] = array[j++];
            }
        }

        for (int k = l; k <= h; k++) {
            array[k] = tmpArray[k];
        }
    }

    public static void mergeBySentry(int[] array, int l, int m, int h) {
        int[] leftArray = new int[m - l + 2];
        int[] rightArray = new int[h - m + 1];

        for (int i = 0; i <= m - l; i++) {
            leftArray[i] = array[l + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArray[m - l + 1] = Integer.MAX_VALUE;

        for (int i = 0; i <= h - m - 1; i++) {
            rightArray[i] = array[m + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArray[h - m] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = 0; k <= h - l; k++) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArray[i] <= rightArray[j]) {
                array[l + k] = leftArray[i++];
            } else {
                array[l + k] = rightArray[j++];
            }
        }
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
        int[] array = randomArray(100);
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
