package com.ja.app.live_cycle;

import java.util.ArrayList;
import java.util.List;

public class MainThread implements Runnable
{
    public static Thread thread;
    public static MainThread mainThread;
    public static List<String> resource = new ArrayList<>();

    public void run()
    {
        SimpleThread simpleThread = new SimpleThread();
        Thread threadInThread = new Thread(simpleThread);

        System.out.println("Before start(): " + threadInThread.getState());
        threadInThread.start();
        System.out.println("After start(): " + threadInThread.getState());

        try
        {
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("After sleep(): " + threadInThread.getState());

        try
        {
            threadInThread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Finished:  " + threadInThread.getState());
    }

    public static void main(String[] args){
        mainThread = new MainThread();
        thread = new Thread(mainThread);
        thread.start();

        Thread t2 = new Thread(
                () -> {
                    synchronized (resource){
                        for (int i = 0; i < 10000; i++){
                            resource.add("I want be first");
                        }
                    }
                }
        );

        Thread t1 = new Thread(
                () -> {
                    synchronized (resource){
                        for (int i = 0; i < 10000; i++){
                            resource.add("I want be first");
                        }
                        System.out.println("Need resource and be: " + t2.getState());
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        t1.start();
        t2.start();
    }

}