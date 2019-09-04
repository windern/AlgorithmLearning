package com.windern.algorithmlearning.Offer;

public class Offer12 {

    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows;
    private int cols;

    /**
     * 是否存在路径
     *
     * @param array 矩阵的字符串
     * @param rows  行数
     * @param cols  列数
     * @param str   待搜寻的路径字符串
     * @return 是否存在路径
     */
    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        this.rows = rows;
        this.cols = cols;
        char[][] matrix = buildMatrix(array);
        boolean[][] marked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 需要动态从每个节点都循环一遍
                boolean result = backtracking(matrix, str, marked, 0, i, j);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 回溯
     *
     * @param matrix  矩阵
     * @param str     搜索字符
     * @param marked  标记矩阵
     * @param pathLen 路径长度
     * @param r       当前比较元素的位置的行
     * @param c       当前比较元素的位置的列
     * @return 是否成功
     */
    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c) {
        // 有限判断是否不是已经超过长度了，说明上一个已经成功了
        if (pathLen == str.length) {
            return true;
        }

        // 任何一种情况都算有问题，都直接返回
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marked[r][c]) {
            return false;
        }

        // 当前符合条件，标记成功
        marked[r][c] = true;
        for (int[] n : next) {
            boolean result = backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1]);
            if (result) {
                return true;
            }
        }

        // 下面走的路不符合条件，需要重置回来
        marked[r][c] = false;

        return false;
    }

    /**
     * 构建矩阵
     *
     * @param array 字符数组
     * @return 矩阵
     */
    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = array[num++];
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        String arrayStr = "abtgcfcsjdeh";
        String strStr = "bfce";

        Offer12 instance = new Offer12();
        boolean result = instance.hasPath(arrayStr.toCharArray(), 3, 4, strStr.toCharArray());
        System.out.println(result);
    }
}
