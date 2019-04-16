package com.ja.app.executors;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Do not touch!
 *
 * @author Kacper Staszek
 */
public class MyThreadFactory implements ThreadFactory {
    private final String factoryName;
    private AtomicInteger counter = new AtomicInteger(0);

    public MyThreadFactory(String factoryName) {
        this.factoryName = factoryName;

    }

    @Override
    public Thread newThread(Runnable r) {
        counter.incrementAndGet();
        return new Thread(r, factoryName + " " + counter);
    }
}
