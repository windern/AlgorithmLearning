package com.windern.algorithmlearning.Offer;

import java.util.ArrayList;

/**
 * Offer29
 *
 * @author: windern
 * @create: 2019/9/17 19:28
 **/
public class Offer29 {

    public static int[][] createMatrix(int row, int column) {
        int[][] matrix = new int[row][column];
        int num = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = num++;
            }
        }
        return matrix;
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        // r1起始行
        int r1 = 0;
        // r2截止行
        int r2 = matrix.length - 1;
        // c1起始列
        int c1 = 0;
        // c2截止列
        int c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                list.add(matrix[r1][i]);
            }
            for (int i = r1 + 1; i <= r2; i++) {
                list.add(matrix[i][c2]);
            }
            // 要排除r1和r2一样，否则多打印
            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    list.add(matrix[r2][i]);
                }
            }
            // 要排除c1和c2一样，否则多打印
            if (c1 != c2) {
                for (int i = r2 - 1; i >= r1 + 1; i--) {
                    list.add(matrix[i][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = createMatrix(3, 4);

        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
}
