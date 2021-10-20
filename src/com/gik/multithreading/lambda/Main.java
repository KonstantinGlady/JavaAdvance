package com.gik.multithreading.lambda;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("anonymous " + i + " " + Thread.currentThread().getName());//получить текущий поток и имя
                    try {
                        Thread.sleep(1000);//усыпить поток
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.setDaemon(true);//делаем деманом. зависит от основного потока
        t1.start();
        t1.join();//подождать завершение другого потока "что бы напечаталось "End" в конце
        //В данном случае поток main ждет завершения потока t1
        System.out.println("End");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("lambda" + i + " " + Thread.currentThread().getName());
            }
        });
        t2.start();
    }
}
