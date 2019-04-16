package com.ja.app.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * newCachedThreadPool() -->
 * Creates a thread pool that creates new threads as needed, but
 * will reuse previously constructed threads when they are
 * available, and uses the provided ThreadFactory to create
 * new threads when needed.
 * <p>
 * Task:
 * CachedThreadExecutor, create the cached pool executor. Do You have to provide pool size? Submit some tasks to executor.
 * Simulate that the task last for one second. After finishing some tasks submit new number of tasks. Before and after
 * each execution check current pool size. Get to the situation when thread pool size is changing in both
 * directions -> grows and shrinks.
 * <p>
 * tip - ThreadPoolExecutor class might help You :) Maybe You would like to change keepAliveTime? Read documentation.
 *
 *If You would have questions, poke Kacper
 */
public class CachedThreadExecutor {
    public static void main(String[] args) throws InterruptedException {
        MyThreadFactory threadFactory = new MyThreadFactory("CachedThreadPool");
        ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);

        //if (executorService instanceof ThreadPoolExecutor) <- check this out
        changeThreadKeepAliveTime(executorService, 2);

        showCurrentPoolSize(executorService);

        System.out.println("Adding 10 tasks");
        Thread.sleep(1000);

        submitNewTasks(executorService, 10);

        Thread.sleep(1000);

        showCurrentPoolSize(executorService);

        System.out.println("Adding 5 tasks");
        Thread.sleep(1000);


        submitNewTasks(executorService, 5);

        Thread.sleep(1000);

        showCurrentPoolSize(executorService);

        System.out.println("and after next second");
        Thread.sleep(1000);

        showCurrentPoolSize(executorService);

        System.out.println("Adding 15 tasks");
        submitNewTasks(executorService, 15);

        Thread.sleep(2000);

        showCurrentPoolSize(executorService);

        submitNewTasks(executorService, 5);
        //5 because tasks are about to finish!
        Thread.sleep(3000);

        showCurrentPoolSize(executorService);
        //10ms later, they are all GONE!
        Thread.sleep(10);

        showCurrentPoolSize(executorService);

    }

    private static void submitNewTasks(ExecutorService executorService, int numberOfTasks) {

    }

    private static void changeThreadKeepAliveTime(ExecutorService executorService, int time) {

    }

    private static void showCurrentPoolSize(ExecutorService executorService) {

    }
}

