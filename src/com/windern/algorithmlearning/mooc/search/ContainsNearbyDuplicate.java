package com.windern.algorithmlearning.mooc.search;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 *
 * @author windern
 * @date 2020/11/22 17:27
 **/
public class ContainsNearbyDuplicate {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // 存储出现元素的位置<num, index>
        Map<Integer, Integer> map = new HashMap<>(16);

        // [l,r]定义滑动窗口的位置
        int l = 0;
        int r = -1;

        boolean result = false;
        // 左边界到底，结束的情况
        while (l < nums.length) {
            if ((r + 1 < nums.length) && (r - l + 1 <= k)) {
                // 右边界移动
                r++;

                // 如果要put的元素已经存在了，说明true
                if (map.containsKey(nums[r])) {
                    return true;
                }

                map.put(nums[r], r);
            } else {
                // 左边界移动
                l++;
                map.remove(nums[l - 1]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        boolean result = containsNearbyDuplicate(nums, k);
        // result: true
        System.out.println(result);
    }
}
