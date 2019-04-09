package com.ja.app.sending;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Ola Podorska
 */
class Main {

    private final static BlockingQueue<String> mails = new ArrayBlockingQueue<>(10);
    private static final int HOW_MANY = 10;

    public static void main(String[] args) {
        PersonGenerator generator = new PersonGenerator();

        for (int i = 0; i < HOW_MANY; i++) {
            new Thread(() -> {
                String mail = generator.getMail();
                try {
                    Thread.sleep(1000);
                    mails.put(mail);
                    System.out.println("Put mail");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "conqueror " + i).start();
        }

        new Thread(() -> {
            try {
                int counter = 0;
                while (true) {
                    String mail = mails.take();
                    System.out.println("I'm sending: " + mail);
                    counter++;
                    if (counter == HOW_MANY){
                        return;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "sender").start();
    }
}
