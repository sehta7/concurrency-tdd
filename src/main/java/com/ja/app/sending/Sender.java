package com.ja.app.sending;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Ola Podorska
 */
class Sender implements Runnable {

    private final BlockingQueue<String> mails;

    public Sender(BlockingQueue<String> mails) {
        this.mails = mails;
    }

    @Override
    public void run() {
        try {
            while (!mails.isEmpty()) {
                String mail = mails.take();
                System.out.println("I'm sending.. mail: " + mail);
            }
            synchronized (mails) {
                mails.wait();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
