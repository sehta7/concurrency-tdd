package com.ja.app.producent_konsument;

public class Konsument implements Runnable {

    Magazyn m;

    public Konsument(Magazyn m) {
        this.m = m;
    }

    @Override
    public void run() {
        try{
            while (true){
                Thread.sleep(1000);
                m.wezTowar();
            }
        } catch (InterruptedException e){

        }
    }
}
