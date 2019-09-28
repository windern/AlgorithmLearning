package com.windern.algorithmlearning.Algorithms4th.Sort;

public class Insertion extends Example {

    public static void sort(Comparable[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            // 将a[i]插入到a[i-1]、a[i-2]……0的数组中
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j - 1, j);
                }
            }
        }
    }

    public static void sortImprove(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            Comparable tmp = a[i];
            for (int j = i; j > 0; j--) {
                // 要与缓存的数据比较
                if (less(a[j - 1], tmp)) {
                    // 最后插入
                    a[j] = tmp;
                    break;
                } else {
                    // 右移
                    a[j] = a[j - 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = randomArray(10);

        show(array);
//        sort(array);
        sortImprove(array);
        System.out.println(isSorted(array));
        show(array);
    }
}
