package com.windern.algorithmlearning.Offer;

public class Offer14 {

    /**
     * 动态规划的方式
     *
     * @param n 数字
     * @return 结果
     */
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 对应小的数，比如2、3，长度为这个分割的时候只有dp[2]=1 dp[3]=2，但是这时用来算最优解，本身的长度比最优解更大
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(5));
    }
}
