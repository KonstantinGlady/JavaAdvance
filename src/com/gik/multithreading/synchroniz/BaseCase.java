package com.gik.multithreading.synchroniz;

public class BaseCase {

    public static class Counter {
        private int counter;

        public int getCounter() {
            return counter;
        }

        public synchronized void increment() {
            counter++;
        }

        public synchronized void decrement() {
            counter--;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCounter());
    }
}
