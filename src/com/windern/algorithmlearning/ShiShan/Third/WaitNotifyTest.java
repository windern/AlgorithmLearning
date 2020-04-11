package com.windern.algorithmlearning.ShiShan.Third;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.locks.ReentrantLock;

/**
 * WaitNotifyTest
 *
 * @author: windern
 * @create: 2020/4/10 20:58
 **/
public class WaitNotifyTest {

    public static class Print implements Runnable{

        private int num = 1;
        public Object object = new Object();


        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    object.notify();

                    if (num <=100) {
                        System.out.println(Thread.currentThread().getName() + " : " + num);
                        num++;

                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Print print = new Print();
        new Thread(print).start();
        new Thread(print).start();
    }

}
