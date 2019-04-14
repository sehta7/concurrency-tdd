package com.ja.app.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Ola Podorska
 */
class Invoke {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callablesWithTime = Arrays.asList(
                callableWithTime("I'll wait a little", 2),
                callableWithTime("Wow, how much longer?", 4),
                callableWithTime("Wait..", 1));

        List<Callable<String>> callablesWithoutTime = Arrays.asList(
                callableWithoutTime("I don't have to wait"),
                callableWithoutTime("Juupi!"),
                callableWithoutTime("Can do anything"));

       /* String result = null;
        try {
            result = executor.invokeAny(callablesWithTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);*/

        executor.invokeAll(callablesWithoutTime)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);
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
