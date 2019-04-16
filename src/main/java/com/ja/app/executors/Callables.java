package com.ja.app.executors;

import java.util.concurrent.*;

/**
 * newFixedThreadPool() -->
 * A Future represents the result of an asynchronous computation.
 * Methods are provided to check if the computation is complete,
 * to wait for its completion, and to retrieve the result of
 * the computation.  The result can only be retrieved using method
 * get when the computation has completed, blocking if necessary
 * until it is ready.  Cancellation is performed by the cancel method.
 * <p>
 * Task:
 * You have one thread with one task (print some text). You need to use proper method to check if task has already done.
 * </p>
 * If You would have questions, don't poke Ola, only Kacper
 */
class Callables {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(new MyBigCallable<String>());
        checkIfTaskIsDone(future);
        executor.shutdown();

    }

    private static void checkIfTaskIsDone(Future<String> future) throws ExecutionException, InterruptedException {
    }
}
