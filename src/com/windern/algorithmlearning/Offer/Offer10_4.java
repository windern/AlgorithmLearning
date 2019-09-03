package com.windern.algorithmlearning.Offer;

import java.util.Arrays;

public class Offer10_4 {

    public static int jumpFloorIIWithDynamic(int target) {
        int[] arrays = new int[target];
        // 核心第一步赋值为1
        Arrays.fill(arrays, 1);

        for (int i = 0; i < target; i++) {
            for (int j = 0; j < i; j++) {
                arrays[i] += arrays[j];
            }
        }

        return arrays[target - 1];
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println("i: " + i + ", result: " + jumpFloorIIWithDynamic(i));
        }
    }
}
