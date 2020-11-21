package com.windern.algorithmlearning.Other;

/**
 * StringTest
 *
 * @author: windern
 * @create: 2020/7/12 10:51
 **/
public class StringTest {

    public static void main(String[] args) {
        try {
            Integer a = null;

            float b = a.floatValue();
            System.out.println(a);
        } catch (final Throwable e) {
            e.printStackTrace();
        }

        int c = 0;
        System.out.println(c);

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1");
        }
    }
}
