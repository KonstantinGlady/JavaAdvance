package com.gik.multithreading.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SimpleReentrantReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.readLock().lock();
        //любой поток может зайти в эту секцию для чтения
        readWriteLock.readLock().unlock();
        readWriteLock.writeLock();
        //только один поток писатель может зайти, при условии что никто не читает
        readWriteLock.writeLock().unlock();
    }
}
