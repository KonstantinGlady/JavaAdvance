package com.gik.multithreading.synchroniz;

public class NotCorrectSynchDoubleCounter {

    private long first;
    private long second;

    public synchronized void incrementFirst() {
        first++;
    }

    public synchronized void decrementFirst() {
        first--;
    }

    public synchronized void incrementSecond() {
        second++;
    }

    public synchronized void decrementSecond() {
        second--;
    }

    public long getFirst() {
        return first;
    }

    public long getSecond() {
        return second;
    }
}
