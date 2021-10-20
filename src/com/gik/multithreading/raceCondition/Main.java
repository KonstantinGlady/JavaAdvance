package com.gik.multithreading.raceCondition;

// Race condition - Когда два паралельных потока одновременно пытаются изменить один рессурс
// проблема решается через synchronized методов класса Counter. блокировка идет на весь класс
public class Main {

    public static class Counter {
        private int value;

        public int getValue() {
            return value;
        }

        public void increment() {  //если добавить synchronized получаем race condition
            value++;
        }

        public void decrement() { //если добавить synchronized получаем race condition
            value--;
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
        System.out.println(counter.getValue());
    }
}
