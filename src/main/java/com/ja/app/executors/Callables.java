package com.ja.app.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Ola Podorska
 */
class Callables {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(new MyBigCallable());

        while (!future.isDone()){
            System.out.println("I can't give you what you want");
            future.get();
        }
        System.out.println("Surprise");
        System.out.println(future.get());

    }
}
