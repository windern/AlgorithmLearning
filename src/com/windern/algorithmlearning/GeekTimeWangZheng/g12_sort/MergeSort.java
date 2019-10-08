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
        merge(array, l, mid, h);
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
