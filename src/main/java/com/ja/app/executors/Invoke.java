package com.ja.app.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * newWorkStealingPool() -->
 * Creates a work-stealing thread pool using the number of
 * availableProcessors available processors as its target
 * parallelism level.
 *
 * invokeAny - Executes the given tasks, returning the result
 * of one that has completed successfully (i.e., without throwing
 * an exception), if any do.
 *
 * invokeAll - Executes the given tasks, returning a list of Futures
 * holding their status and results when all complete.
 * <p>
 * Task:
 * Create two types of list: with result to return and with result to return after some time.
 * Use invoke() and invokeAll() to see the difference. What are they doing?
 * </p>
 */
class Invoke {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        //invokeAny() on executor

        //invokeAll() on executor
    }

    static Callable<String> callableWithTime(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

    static Callable<String> callableWithoutTime(String result) {
        return () -> result;
    }
}
