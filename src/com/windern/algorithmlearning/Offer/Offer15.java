package com.windern.algorithmlearning.Offer;

public class Offer15 {

    public static int numberOf1(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n-1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(-5));
        System.out.println(Integer.bitCount(-5));
    }
}
