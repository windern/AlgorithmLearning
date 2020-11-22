package com.windern.algorithmlearning.mooc.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 242. 有效的字母异位词
 *
 * @author windern
 * @date 2020/11/22 15:53
 **/
public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        // 存储字符对应的个数
        Map<Character, Integer> sMap = createCharMap(s);
        Map<Character, Integer> tMap = createCharMap(t);

        // 考虑集合不一样的情况，如果s集合小，那只看下面比较的时候还是可能返回true
        if (sMap.size() != tMap.size()) {
            return false;
        }

        for (Entry<Character, Integer> entry : sMap.entrySet()) {
            if (!tMap.containsKey(entry.getKey())
                || entry.getValue().intValue() != tMap.get(entry.getKey())) {
                return false;
            }
        }

        return true;
    }

    /**
     * 创建字符个数Map的结果
     *
     * @param s 字符串
     * @return 字符个数Map
     */
    public static Map<Character, Integer> createCharMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);
        // result: true
        System.out.println(result);
    }
}
