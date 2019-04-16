package com.ja.app.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SingleThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyLittleRunnable(), "single thread");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(thread);
        System.out.println("What am I doing?");
        for (int i = 0; i < 5; i++) {
            executorService.execute(thread);
        }
        executorService.shutdown();
        //executorService.shutdownNow();
        System.out.println("Someone tell me..?");
    }
}
