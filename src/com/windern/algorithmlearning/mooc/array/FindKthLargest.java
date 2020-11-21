package com.windern.algorithmlearning.mooc.array;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author windern
 * @date 2020/11/21 20:27
 **/
public class FindKthLargest {

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = partion(nums, l, r);
        quickSort(nums, l, mid - 1);
        quickSort(nums, mid + 1, r);
    }

    /**
     * 排序[l,r]区间的元素
     *
     * @param nums 数组
     * @param l 左索引
     * @param r 右索引
     * @return 返回锚定的中间位置
     */
    public static int partion(int[] nums, int l, int r) {
        if (l >= r) {
            return l;
        }

        int value = nums[r];
        int p = l;
        for (int i = l; i <= r - 1; i++) {
            if (nums[i] < value) {
                swap(nums, i, p);
                p++;
            }
        }
        swap(nums, p, r);
        return p;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
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
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
