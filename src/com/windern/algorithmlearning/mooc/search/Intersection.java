package com.windern.algorithmlearning.mooc.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 *
 * @author windern
 * @date 2020/11/22 14:51
 **/
public class Intersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        // 定义两个Set存储出现的元素
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for (int i : nums1) {
            nums1Set.add(i);
        }

        for (int i : nums2) {
            if (nums1Set.contains(i)) {
                resultSet.add(i);
            }
        }

        Object[] objects = resultSet.toArray();
        int[] result = new int[objects.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (Integer) objects[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] result = intersection(nums1, nums2);
        // result: [9,4]
        System.out.println(Arrays.toString(result));
    }
}
