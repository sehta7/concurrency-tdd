package com.ja.app.sending;

import java.util.concurrent.BlockingQueue;

/**
 * @author Ola Podorska
 */
class Conqueror implements Runnable {

    private final BlockingQueue<String> mails;
    private PersonGenerator generator;

    public Conqueror(BlockingQueue<String> mails) {
        this.mails = mails;
        generator = new PersonGenerator();
    }

    @Override
    public void run() {
        String mail = generator.getMail();
        System.out.println("I'v got mail " + mail);
        try {
            mails.put(mail);
            synchronized (mails){
                mails.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
