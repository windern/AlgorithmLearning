package com.windern.algorithmlearning.GeekTimeWangZheng.g09_queue;

import java.util.Arrays;

public class CircularQueue {

    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) {
            return false;
        }

        items[tail] = item;
        // +1余n来防止越界，并返回到头部
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }

        String item = items[head];
        head = (head + 1) % n;
        return item;
    }

    @Override
    public String toString() {
        return "CircularQueue{" +
                "items=" + Arrays.toString(items) +
                ", n=" + n +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(10);
        for (int i = 1; i <= 10; i++) {
            circularQueue.enqueue(String.valueOf(i));
        }
        System.out.println(circularQueue);

        String d1 = circularQueue.dequeue();
        System.out.println(d1);
        System.out.println(circularQueue);
    }
}
