package com.ja.app.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool() -->
 * Creates a thread pool that reuses a fixed number of threads
 * operating off a shared unbounded queue.  At any point, at most
 * nThreads threads will be active processing tasks.
 * If additional tasks are submitted when all threads are active,
 * they will wait in the queue until a thread is available.
 * <p>
 * Task:
 * Give a few tasks for available threads, and check (print name of thread) which one do it.
 * Check what is the difference between shoutdown() and shoutdownNow()
 * Than go to SingleThread class, it'll be the same with one difference.
 * </p>
 */
class FixThread {

    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("FixedThreadPool");
        ExecutorService executorService = Executors.newFixedThreadPool(3,factory);
        System.out.println("What am I doing?");

        //give tasks for threads

        executorService.shutdown();
        //executorService.shutdownNow();
        System.out.println("Someone tell me..?");
    }
}
