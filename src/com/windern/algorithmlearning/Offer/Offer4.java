package com.windern.algorithmlearning.Offer;

public class Offer4 {

    public static boolean find(int target, int[][] matrix) {
        int row = 0;
        int column = matrix[0].length - 1;

        while (row <= matrix.length - 1 && column >= 0) {
            if (target == matrix[row][column]) {
                return true;
            } else if (target < matrix[row][column]) {
                column--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        boolean result = find(80, matrix);
        System.out.println(result);
    }
}
