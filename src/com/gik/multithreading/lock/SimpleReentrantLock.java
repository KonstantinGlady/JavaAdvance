package com.gik.multithreading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleReentrantLock {
    public static void main(String[] args) {
        //Более гибкий способ блокировок чем synchronized. можно использовать в разным методах lock и unlock
        Lock lock = new ReentrantLock();

        try {
            lock.lock();
            //lock.tryLock() // пытается захватить если нет возвращает false , есть перегрузка с параметром таймером
            // секция с кодом
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
