package com.windern.algorithmlearning.Algorithms4th.Sort;

public class Selection extends Example {

    public static void sort(Comparable[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                // 比较是a[j]和a[min]，不要误写成a[j]和a[i]
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] array = randomArray(10);

        show(array);
        sort(array);
        System.out.println(isSorted(array));
        show(array);
    }
}
