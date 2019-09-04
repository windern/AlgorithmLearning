package com.windern.algorithmlearning.Offer;

public class Offer13 {

    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int cnt = 0;
    private int rows;
    private int cols;
    private int threshold;
    private int[][] digitSum;

    /**
     * 移动数数
     *
     * @param threshold 限制
     * @param rows      行
     * @param cols      列
     * @return 总和
     */
    public int movingCount(int threshold, int rows, int cols) {
        this.threshold = threshold;
        this.rows = rows;
        this.cols = cols;
        digitSum = new int[rows][cols];
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return cnt;
    }

    /**
     * 深度优先
     *
     * @param marked 标记矩阵
     * @param r      行
     * @param c      列
     */
    private void dfs(boolean[][] marked, int r, int c) {
        // 异常排除失败的
        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c]) {
            return;
        }
        // 数值超过失败的
        if (digitSum[r][c] > threshold) {
            return;
        }

        marked[r][c] = true;
        cnt++;
        for (int[] n : next) {
            dfs(marked, r + n[0], c + n[1]);
        }
    }

    /**
     * 初始化digitSum的数组
     */
    private void initDigitSum() {
        int[] digitSumOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < digitSumOne.length; i++) {
            int n = i;
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n = n / 10;
            }
            digitSumOne[i] = sum;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
            }
        }
    }

    public static void main(String[] args) {
        Offer13 instance = new Offer13();
        int count = instance.movingCount(3, 3, 3);
        System.out.println(count);
    }
}
