package com.windern.algorithmlearning.mooc.search;

import java.util.*;
import java.util.Map.Entry;

/**
 * 451. 根据字符出现频率排序
 *
 * @author windern
 * @date 2020/11/22 16:24
 **/
public class FrequencySort {

    public static String frequencySort(String s) {
        // 存储字符个数
        Map<Character, Integer> map = createCharMap(s);
        System.out.println(map);
        // 反向根据个数存储字符，可能存在相同个数的元素，用一个列表存储字符
        TreeMap<Integer, List<Character>> treeMap = new TreeMap<>(Comparator.reverseOrder());

        int sum = 0;
        for (Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            Character c = entry.getKey();
            if (!treeMap.containsKey(count)) {
                treeMap.put(count, new ArrayList<>());
            }

            List<Character> list = treeMap.get(count);
            list.add(c);

            sum += count;
        }
        System.out.println(treeMap);

        char[] array = new char[sum];
        int i = 0;
        for (Entry<Integer, List<Character>> entry : treeMap.entrySet()) {
            int count = entry.getKey();
            List<Character> list = entry.getValue();

            for (Character c : list) {
                for (int j = 0; j < count; j++) {
                    array[i++] = c;
                }
            }
        }

        return String.valueOf(array);
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
        String s = "tree";
        String result = frequencySort(s);
        // result: eert
        System.out.println(result);
    }
}
