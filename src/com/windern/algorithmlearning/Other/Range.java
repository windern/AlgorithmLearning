package com.windern.algorithmlearning.Other;

import java.util.ArrayList;
import java.util.List;

/**
 * Rang
 * 使用回溯算法全排列
 *
 * @author: windern
 * @create: 2020/5/19 16:37
 **/
public class Range {

    public static void range(int[] array, List<Integer> chooseList) {
        if (array.length == chooseList.size()) {
            System.out.println(chooseList);
        }

        for (int i = 0; i < array.length; i++) {
            Integer choose = array[i];

            if (!chooseList.contains(choose)) {
                chooseList.add(choose);
                range(array, chooseList);
                chooseList.remove(choose);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        range(array, new ArrayList<>());
    }
}
