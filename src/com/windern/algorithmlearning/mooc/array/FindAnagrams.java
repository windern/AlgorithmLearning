package com.windern.algorithmlearning.mooc.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @author windern
 * @date 2020/11/22 09:38
 **/
public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        // 存放结果
        List<Integer> result = new ArrayList<>();

        // 存储目标字符串的各个字符的各数
        Map<Character, Integer> targetCount = computeTargetCount(p);

        // 字符串数组
        char[] array = s.toCharArray();

        // 定义滑动窗口[l,r]
        int l = 0;
        int r = -1;

        // 为了提效，将窗口的结果存起来，而不是每次都[l,r]都重新算一遍
        Map<Character, Integer> windowCount = new HashMap<>();

        // l左边界走完
        while (l < array.length) {
            int nowLength = r - l + 1;
            // 先保证字符串长度一样
            if ((r + 1 <= array.length - 1) && (nowLength < p.length())) {
                // 右边界移动的情况
                r++;
                increaseNum(windowCount, array[r]);
            } else {
                // 左边界移动的情况
                l++;
                decreaseNum(windowCount, array[l - 1]);
            }

            // 移动后重新计算
            nowLength = r - l + 1;
            if (nowLength == p.length()) {
                if (compareTwoMap(windowCount, targetCount)) {
                    // 长度相等，且字符个数一样，符合结果
                    result.add(l);
                }
            }
        }

        return result;
    }

    /**
     * 字符个数增加
     *
     * @param targetCount 目标
     * @param c 字符
     */
    public static void increaseNum(Map<Character, Integer> targetCount, char c) {
        if (targetCount.containsKey(c)) {
            int count = targetCount.get(c);
            targetCount.put(c, count + 1);
        } else {
            targetCount.put(c, 1);
        }
    }

    /**
     * 字符个数减少
     *
     * @param targetCount 目标
     * @param c 字符
     */
    public static void decreaseNum(Map<Character, Integer> targetCount, char c) {
        if (targetCount.containsKey(c)) {
            int count = targetCount.get(c);
            targetCount.put(c, count - 1);
        }
    }

    /**
     * 计算目标字符串的字符个数
     *
     * @param p 目标字符串
     * @return 字符个数
     */
    private static Map<Character, Integer> computeTargetCount(String p) {
        char[] targetArray = p.toCharArray();
        return computeTargetCount(targetArray, 0, targetArray.length - 1);
    }

    /**
     * 是否匹配满足异位词的定义[l,r]
     *
     * @param array 数组
     * @param l 左边界
     * @param r 右边界
     * @param charCount 字符个数
     * @return 是否匹配
     */
    private static boolean isMatch(char[] array, int l, int r, Map<Character, Integer> charCount) {
        Map<Character, Integer> compareCount = computeTargetCount(array, l, r);
        return compareTwoMap(compareCount, charCount);
    }

    /**
     * 比较两个是否相等
     *
     * @param compareCount 一个
     * @param charCount 另一个
     * @return 是否相等
     */
    private static boolean compareTwoMap(Map<Character, Integer> compareCount,
        Map<Character, Integer> charCount) {
        for (Entry<Character, Integer> entry : charCount.entrySet()) {
            Integer count = compareCount.get(entry.getKey());
            if (count == null || count.intValue() != entry.getValue()) {
                // 数字不存在或者数字不相等，表示不是
                return false;
            }
        }
        return true;
    }

    /**
     * 计算目标字符串的字符个数
     *
     * @param targetArray 目标
     * @param l 左边界
     * @param r 右边界
     * @return 字符个数
     */
    private static Map<Character, Integer> computeTargetCount(char[] targetArray, int l, int r) {
        Map<Character, Integer> targetCount = new HashMap<>();
        for (int i = l; i <= r; i++) {
            char c = targetArray[i];
            if (targetCount.containsKey(c)) {
                int count = targetCount.get(c);
                targetCount.put(c, count + 1);
            } else {
                targetCount.put(c, 1);
            }
        }
        return targetCount;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> result = findAnagrams(s, p);
        // result: [0, 1, 2]
        System.out.println(result);
    }
}
