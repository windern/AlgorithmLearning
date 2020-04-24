package com.windern.algorithmlearning.ShiShan.Third;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExcutorTest
 *
 * @author: windern
 * @create: 2020/4/11 15:54
 **/
public class ExcutorTest {

    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println("start " + Thread.currentThread().getName());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("end " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            executorService.submit(myTask);
        }
    }

}
