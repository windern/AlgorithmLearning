package com.windern.algorithmlearning.ShiShan.Third;

public class Memory21 {

    public static class HelloWorld {
        private int data = 0;

        public void increment() throws InterruptedException {

            Thread.sleep(100);
            data++;
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();

        for (int i = 0; i < 100; i++) {
            final int j = i;
            new Thread() {

                @Override
                public void run() {
                    System.out.println("index:" + j);
                    try {
                        helloWorld.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("helloWorld.data:" + helloWorld.data);
                }
            }.start();
        }

    }
}
