package com.windern.algorithmlearning.Offer;

public class Offer47 {

    public static int getMost1(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }

        int[][] maxValues = new int[values.length][values[0].length];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                int left = 0;
                int top = 0;
                if (i > 0) {
                    top = maxValues[i - 1][j];
                }
                if (j > 0) {
                    left = maxValues[i][j - 1];
                }
                maxValues[i][j] = Math.max(top, left) + values[i][j];
            }
        }

        return maxValues[values.length - 1][values[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };

        int most1 = getMost1(matrix);
        System.out.println(most1);
    }
}
