package com.windern.algorithmlearning.mooc.array;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author windern
 * @date 2020/11/21 20:27
 **/
public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        return findKthLargestInRange(nums, nums.length - k, 0, nums.length - 1);
    }

    /**
     * 从区间[l,r]中寻找k的位置
     *
     * @param nums 数组
     * @param k k索引位置
     * @param l 左索引
     * @param r 右索引
     * @return k位置的value
     */
    public static int findKthLargestInRange(int[] nums, int k, int l, int r) {
        int partion = partion(nums, l, r);
        if (k == partion) {
            return nums[partion];
        } else if (k < partion) {
            return findKthLargestInRange(nums, k, l, partion - 1);
        } else {
            return findKthLargestInRange(nums, k, partion + 1, r);
        }
    }

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
        List<Integer> list = new Random().ints(0, n).distinct().limit(n).boxed()
            .collect(Collectors.toList());
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    public static void main(String[] args) {
//        int[] array = randomArray(100);
//        System.out.println(Arrays.toString(array));
//        quickSort(array, 0, array.length - 1);
//        System.out.println(Arrays.toString(array));

        int[] nums = {3, 2, 1, 5, 6, 4};
        int result = findKthLargest(nums, 2);
        System.out.println(result);
    }
}
