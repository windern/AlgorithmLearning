package com.windern.algorithmlearning.mooc.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *
 * @author windern
 * @date 2020/11/22 07:45
 **/
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<>();

        // [l,r]为滑动的窗口，保持无数据的状态
        int l = 0;
        int r = -1;
        int res = 0;

        // l左边界走完
        while (l < array.length) {
            if (r + 1 < array.length && !set.contains(array[r + 1])) {
                // 右边界可以继续走，而且满足条件
                r++;
                // 窗口数据更新
                set.add(array[r]);
            } else {
                // 左边界动
                l++;
                // 窗口数据更新
                set.remove(array[l - 1]);
            }

            // 有效的解，进行比较
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        int result = lengthOfLongestSubstring(s);
        // result = 5
        System.out.println(result);
    }
}
