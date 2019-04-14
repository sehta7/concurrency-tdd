package com.ja.app.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Ola Podorska
 */
class ScheduleThread {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("I don't have time");
        ScheduledFuture<?> future = scheduledExecutorService.schedule(task, 5, TimeUnit.SECONDS);

        try {
            TimeUnit.MILLISECONDS.sleep(1337);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms", remainingDelay);
        System.out.println();
    }
}
