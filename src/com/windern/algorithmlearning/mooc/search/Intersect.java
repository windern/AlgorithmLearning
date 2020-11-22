package com.windern.algorithmlearning.mooc.search;

import java.util.*;
import java.util.Map.Entry;

/**
 * 350. 两个数组的交集 II
 *
 * @author windern
 * @date 2020/11/22 15:40
 **/
public class Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        // map存储个数
        Map<Integer, Integer> nums1Map = new HashMap<>(nums1.length);
        Map<Integer, Integer> nums2Map = new HashMap<>(nums2.length);

        for (int i : nums1) {
            if (nums1Map.containsKey(i)) {
                nums1Map.put(i, nums1Map.get(i) + 1);
            } else {
                nums1Map.put(i, 1);
            }
        }

        for (int i : nums2) {
            if (nums2Map.containsKey(i)) {
                nums2Map.put(i, nums2Map.get(i) + 1);
            } else {
                nums2Map.put(i, 1);
            }
        }

        int sum = 0;
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (Entry<Integer, Integer> entry : nums1Map.entrySet()) {
            if (nums2Map.containsKey(entry.getKey())) {
                int count = Math.min(entry.getValue(), nums2Map.get(entry.getKey()));
                resultMap.put(entry.getKey(), count);
                sum += count;
            }
        }

        int[] result = new int[sum];
        int j = 0;
        for (Entry<Integer, Integer> entry : resultMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result[j++] = entry.getKey();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersect(nums1, nums2);
        // result: [2,2]
        System.out.println(Arrays.toString(result));
    }
}
