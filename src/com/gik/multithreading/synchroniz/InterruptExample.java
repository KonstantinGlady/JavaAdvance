package com.gik.multithreading.synchroniz;

public class InterruptExample {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            boolean interrupted = false;// добавляем флаг если попытается прервать спящий поток отработает InterruptedException
            for (int i = 0; i < 1000; i++) {
                if (Thread.currentThread().isInterrupted() || interrupted) { //isInterrupted() стандартное прерывания потока если не в sleep()
                    break;
                }
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
