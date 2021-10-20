package com.gik.multithreading.executors;

import java.util.concurrent.*;

public class RequestApp {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //ExecutorService service = Executors.newCachedThreadPool(); // масштабируется кол-во
        //ExecutorService service = Executors.newSingleThreadExecutor(); //один поток
        ExecutorService service = Executors.newFixedThreadPool(10);//задданое кол-во потоков
        for (int i = 0; i < 2; i++) {

            Thread.sleep(1000);
            for (int n = 0; n < 3; n++) {

                service.execute(() -> { //execute() - исполняет Runnable асинхронно в паралельном потоке. ничего не возвращает
                    System.out.println(1);
                });
            }
        }
        service.shutdown();
        //service.shutdownNow();// попытается прекратить сразу, но это не точно. Остановки происходят через метод interrupt()

        //возвращаем Future можно проверить завершена ли задача
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future future = executorService.submit(() -> {
            System.out.println("Асинхронная задача");
        });
        System.out.println(future.get());//вернет Null при завершении
        executorService.shutdown();

        //Callable анонимный класс
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        Future<String> future1 = executorService1.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Асинхронный вызов");
                return "Результат вызова";
            }
        });
        System.out.println("callable " + future1.get());
        executorService1.shutdown();

        //Callable лямбда
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        Future<String> future2 = executorService2.submit(() -> {
            System.out.println("лямбда асинхронный вызов ");
            Thread.sleep(2000);//в этом случае при вызове future2.get() main поток перейдет в ожидание окончания работы потока-исполнителя
            return "лямбда результат";
        });
        System.out.println("Результат вызова " + future2.get());
        executorService2.shutdown();
    }
}
