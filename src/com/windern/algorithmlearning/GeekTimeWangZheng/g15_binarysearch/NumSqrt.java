package com.windern.algorithmlearning.GeekTimeWangZheng.g15_binarysearch;

public class NumSqrt {

    public static double sqrt(double x) {
        double low = 0;
        double high = x;

        while (true) {
            double mid = low + (high - low) / 2;

            boolean match = (mid + 0.000001) * (mid + 0.000001) > x && (mid - 0.000001) * (mid - 0.000001) < x;
            if (match) {
                return mid;
            } else if (mid * mid > x) {
                high = mid;
            } else {
                low = mid;
            }
        }
    }

    public static void main(String[] args) {
        double x = 7;
        double sqrt = sqrt(x);
        System.out.println(sqrt);
    }
}
