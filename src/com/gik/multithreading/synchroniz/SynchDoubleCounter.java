package com.gik.multithreading.synchroniz;

public class SynchDoubleCounter {
    private long first;
    private long second;

    private final Object monFirst = new Object();
    private final Object monSecond = new Object();

    public void incrementFirst() {
        synchronized (monFirst) {
            first++;
        }
    }

    public void decrementFirst() {
        synchronized (monFirst) {
            first--;
        }
    }

    public void incrementSecond() {
        synchronized (monSecond) {
            second++;
        }
    }

    public void decrementSecond() {
        synchronized (monSecond) {
            second--;
        }
    }
}
