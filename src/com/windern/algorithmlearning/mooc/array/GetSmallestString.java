package com.windern.algorithmlearning.mooc.array;

/**
 * 5606. 具有给定数值的最小字符串
 *
 * @author windern
 * @date 2020/11/22 11:28
 **/
public class GetSmallestString {

    public static String getSmallestString(int n, int k) {
        // 目标，尽量用最小的值，贪心

        String letters = "abcdefghijklmnopqrstuvwxyz";

        // 结果
//        String result = "";

        // 底层char数组来替换字符串的累加，效率更高
        char[] result = new char[n];

        int loopN = n;
        int loopK = k;

        // 是否可以提前退出
        boolean canPreOut = false;
        while (loopN > 0) {
            if (canPreOut) {
                // result = letters.charAt(0) + result;
                result[loopN - 1] = letters.charAt(0);
            } else {
                // int lastValue = getLastValue(loopN, loopK);
                int lastValue = Math.min(26, loopK - (loopN - 1));
                if (lastValue == 1) {
                    canPreOut = true;
                }
                //result = letters.charAt(lastValue - 1) + result;
                result[loopN - 1] = letters.charAt(lastValue - 1);

                loopK = loopK - lastValue;
            }
            loopN--;
        }

        return String.valueOf(result);
    }

    private static int getLastValue(int n, int k) {
        if (n == 1) {
            return k;
        } else {
            // 至少n-1个1，开始当前面都是1
            int left = k - (n - 1);
            if (left >= 26) {
                return 26;
            } else {
                return left;
            }
        }
    }

    public static void main(String[] args) {
        String result = getSmallestString(5, 73);
        System.out.println(result);
    }
}
