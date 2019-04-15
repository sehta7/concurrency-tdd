package com.ja.app.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CachedThreadExecutor {
    public static void main(String[] args) throws InterruptedException {
        MyThreadFactory threadFactory = new MyThreadFactory("CachedThreadPool");
        ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);

        changeThreadKeepAliveTime(executorService,2);

        showCurrentPoolSize(executorService);

        System.out.println("Adding 10 tasks");
        Thread.sleep(1000);

        submitNewTasks(executorService,10);


        Thread.sleep(1000);

        showCurrentPoolSize(executorService);

        System.out.println("Adding 5 tasks");
        Thread.sleep(1000);


        submitNewTasks(executorService,5);

        Thread.sleep(1000);

        showCurrentPoolSize(executorService);

        System.out.println("and after next second");
        Thread.sleep(1000);

        showCurrentPoolSize(executorService);

        System.out.println("Adding 15 tasks");
        submitNewTasks(executorService,15);

        Thread.sleep(2000);

        showCurrentPoolSize(executorService);

        submitNewTasks(executorService,5);
        //5 because tasks are about to finish!
        Thread.sleep(3000);

        showCurrentPoolSize(executorService);
        //10ms later, they are all GONE!
        Thread.sleep(10);

        showCurrentPoolSize(executorService);

    }

    private static void submitNewTasks(ExecutorService executorService, int numberOfTasks) {
        for (int i = 0; i < numberOfTasks; i++) {
            int taskNumber = i;
            executorService.submit(() -> {
                System.out.println("Doing task " + taskNumber + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("Was interrupted. "+Thread.currentThread().getName());
                }
            });
        }
    }

    private static void changeThreadKeepAliveTime(ExecutorService executorService, int time) {
        if(executorService instanceof ThreadPoolExecutor){
            ((ThreadPoolExecutor) executorService).setKeepAliveTime(time, TimeUnit.SECONDS);
        }
    }

    private static void showCurrentPoolSize(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor) {
            System.out.println(
                    "Pool size is now " +
                            ((ThreadPoolExecutor) executorService).getPoolSize()
            );

            System.out.println("Maximum pool size was "+((ThreadPoolExecutor) executorService).getLargestPoolSize());
        }
    }
}

