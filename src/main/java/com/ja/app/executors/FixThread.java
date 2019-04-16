package com.ja.app.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FixThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyLittleRunnable(), "fix thread");
        ExecutorService executorService = Executors.newFixedThreadPool(3);
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
