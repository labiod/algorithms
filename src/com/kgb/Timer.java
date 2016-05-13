package com.kgb;

/**
 * Created by k.betlej on 8/10/15.
 */
public class Timer {
    private long result;
    private long startTime;
    private boolean started;

    public void start() {
        startTime = System.nanoTime();
        started = true;
    }

    public void stop() {
        long endTime = System.nanoTime();
        if(started) {
            result = endTime - startTime;
            started = false;
        }
    }

    public long getSpendTime() {
        return result;
    }

    public long getSpendTimeInMicro() {
        return result/1000;
    }
}
