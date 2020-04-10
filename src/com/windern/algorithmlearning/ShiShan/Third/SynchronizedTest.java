package com.windern.algorithmlearning.ShiShan.Third;

/**
 * SynchronizedTest
 *
 * @author: windern
 * @create: 2020/4/10 20:35
 **/
public class SynchronizedTest implements Runnable {

    int i = 0;

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        new Thread(synchronizedTest).start();
        new Thread(synchronizedTest).start();

    }

    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            increase();
        }
    }

    public synchronized void increase() {
        System.out.println(Thread.currentThread().getId() + " before i: "+ i);
        i++;
        System.out.println(Thread.currentThread().getId() + " after i: "+ i);
    }
}
