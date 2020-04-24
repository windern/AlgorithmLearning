package com.windern.algorithmlearning.interview.boss;

import java.util.ArrayList;
import java.util.List;

/**
 * Jiaoji
 *
 * @author: windern
 * @create: 2020/4/24 19:13
 **/
public class Jiaoji {

    public static int[] retainAll(int[] array1, int[] array2) {
        int minLength = Math.min(array1.length, array2.length);
        int[] result = new int[minLength];
        int a = 0;
        int b = 0;
        int resultIndex = 0;
        while (a < array1.length && b < array2.length) {
            if (array1[a] == array2[b]) {
                result[resultIndex] = array1[a];
                a++;
                b++;
                resultIndex++;
            } else if (array1[a] < array2[b]) {
                a++;
            } else {
                b++;
            }
        }
        int[] finalResult = new int[resultIndex];
        for (int i = 0; i < resultIndex; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 5, 7, 9};
        int[] array2 = {1, 7, 8};
        int[] result = retainAll(array1, array2);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
