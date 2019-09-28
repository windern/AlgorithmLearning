package com.windern.algorithmlearning.Algorithms4th.Sort;

public class Shell extends Example {

    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        // 生成序列1，4，13，40……
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // i从h开始
            for (int i = h; i < n; i++) {
                //将a[i]插入到a[i-h]、a[i-2*h]、a[i-3*h]……的序列中
                for (int j = i; j - h >= 0; j -= h) {
                    if (less(a[j], a[j - h])) {
                        exch(a, j, j - h);
                    }
                }
            }

            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] array = randomArray(100);

        show(array);
        sort(array);
        System.out.println(isSorted(array));
        show(array);
    }
}
