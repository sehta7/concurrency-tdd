package com.ja.app.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * newSingleThreadExecutor() -->
 * Creates an Executor that uses a single worker thread operating
 * off an unbounded queue. Tasks are guaranteed to execute
 * sequentially, and no more than one task will be active at any
 * given time.
 * <p>
 * Task:
 * Do you remember FixThread? Try the same thing here - give a few tasks for available threads,
 * and check (print name of thread) which one do it.
 * </p>
 */
class SingleThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyLittleRunnable(), "single thread");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(thread);
        System.out.println("What am I doing?");

        //give tasks for threads

        executorService.shutdown();
        //executorService.shutdownNow();
        System.out.println("Someone tell me..?");
    }
}
