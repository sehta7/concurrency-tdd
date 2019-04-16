package com.ja.app.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Do not touch!
 *
 * @author Ola Podorska
 */
class MyBigCallable<T extends String> implements Callable {
    @Override
    public T call() throws Exception {
        try {
            TimeUnit.SECONDS.sleep(1);
            return (T)"I'm BIG and strong and return magic things!";
        }
        catch (InterruptedException e) {
            throw new IllegalStateException("task interrupted", e);
        }
    }
}
