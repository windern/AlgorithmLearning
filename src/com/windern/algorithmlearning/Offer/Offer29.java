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
                matrix[row][column] = num++;
            }
        }
        return matrix;
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        int r = 0;
        int c = matrix[0].length;

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = createMatrix(4, 4);

        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);
    }
}
