package com.ja.app.producent_konsument;

public class Magazyn {
    String towar;
    boolean jestTowar = false;
    boolean jestZaplata = false;

    synchronized void dajTowar(String towar) throws InterruptedException {
        while (!jestZaplata){
            System.out.println("Czekam na zapłatę");
            Thread.sleep(1000);
            notifyAll();
            this.wait();
        }
        this.towar = towar;
        jestTowar = true;
        notifyAll();
    }

    synchronized String wezTowar() throws InterruptedException {
        while (!jestTowar){
            System.out.println("Czekam na towar");
            Thread.sleep(1000);
            notifyAll();
            this.wait();
        }
        jestZaplata = true;
        notifyAll();
        return towar;
    }

    public static void main(String[] args) throws InterruptedException {
        Magazyn magazyn = new Magazyn();
        Thread producent = new Thread(new Producent(magazyn));
        Thread konsument = new Thread(new Konsument(magazyn));

        konsument.start();
        producent.start();

    }
}
