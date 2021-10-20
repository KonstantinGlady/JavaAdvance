package com.gik.multithreading.synchroniz;

public class ExampleDeadLock {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();
        t1.start();
        t2.start();
    }

    private static class ThreadOne extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("ThreadOne захватил lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadOne ожидает lock2");
                synchronized (lock2) {
                    System.out.println("ThreadOne захватил lock1 и lock2");
                }
            }
        }
    }

    private static class ThreadTwo extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("ThreadTwo захватил lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadTwo ожидает lock1");
                synchronized (lock1) {
                    System.out.println("ThreadTwo захватил lock2 и lock1");
                }
            }
        }
    }
}
