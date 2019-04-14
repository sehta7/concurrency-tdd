package com.ja.app.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author Ola Podorska
 */
class MyBigCallable implements Callable {
    @Override
    public Object call() throws Exception {
        try {
            TimeUnit.SECONDS.sleep(1);
            return "I'm BIG and strong and return magic things!";
        }
        catch (InterruptedException e) {
            throw new IllegalStateException("task interrupted", e);
        }
    }
}
