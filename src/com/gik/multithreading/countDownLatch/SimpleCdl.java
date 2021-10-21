package com.gik.multithreading.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class SimpleCdl {
    public static void main(String[] args) {

        final int THREADS_NUMBERS = 6;
        //CountDownLatch ждет пока заданное количество потоков завершит работу с помощью countDown() после этого продолжает
        // со строки await()
        final CountDownLatch cdl = new CountDownLatch(THREADS_NUMBERS);
        System.out.println("Начинаем работу");

        new Thread(() -> {
            for (int i = 0; i < THREADS_NUMBERS; i++) {
                final int w = i;
                try {
                    Thread.sleep(500 + (int) (500 * Math.random()));
                    cdl.countDown();//Поток завершил работу
                    System.out.println("Поток " + w + " завершил работу");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            cdl.await();
            //Пока счетчик не равен нулю, ждем здесь
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Работа завершена");
    }
}
