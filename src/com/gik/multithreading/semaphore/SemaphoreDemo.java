package com.gik.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        //Semaphore выделяется 2 потока acquire() резервируем release() освобождаем.что бы зарезервировать свободных
        //потоков должно быть больше 0
        Semaphore smp = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Поток " + w + " перед семафором");
                    smp.acquire();
                    System.out.println("Поток " + w + " получил семафор");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Поток " + w + " освободил семафор");
                    smp.release();
                }
            }).start();
        }
    }
}
