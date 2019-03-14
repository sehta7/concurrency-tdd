package com.ja.app.producent_konsument;

public class Producent implements Runnable {

    Magazyn m;
    int towarId;

    public Producent(Magazyn m) {
        this.m = m;
    }

    @Override
    public void run() {
        try{
            while (true){
                Thread.sleep(1000);
                m.dajTowar("Id: " + towarId);
                towarId++;
            }
        } catch (InterruptedException e){

        }
    }
}
