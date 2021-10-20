package com.gik.multithreading.synchroniz;

public class WaitNotifyClass {

    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        WaitNotifyClass waitNotifyObj = new WaitNotifyClass();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                waitNotifyObj.printA();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                waitNotifyObj.printB();
            }
        });
        t1.start();
        t2.start();
    }

    public void printA() {
        synchronized (mon) {
            try {
                while (currentLetter != 'A') {
                    mon.wait();
                }
                System.out.println("A");
                currentLetter = 'B';
                mon.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                while (currentLetter != 'B') {
                    mon.wait();
                }
                System.out.println("B");
                currentLetter = 'A';
                mon.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
