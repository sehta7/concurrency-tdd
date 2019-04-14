package com.ja.app.executors;

/**
 * @author Ola Podorska
 */
class MyLittleRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
