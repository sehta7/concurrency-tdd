package com.ja.app.dziala;

import com.ja.app.dziala.Konto;
import com.ja.app.dziala.Osoba;

import java.time.LocalDate;

/**
 * @author Ola Podorska
 */
public class Przeloty {

    static Osoba ala = new Osoba("Ala", "Kowalska", LocalDate.now());

    static Konto konto = new Konto(1, 1000_000, ala);

    public static void main(String[] args) {
        final int N = 100_000;
        final int KWOTA = 10;


        System.out.println(konto);

        Thread wplacacz = new Thread(() -> {
            for(int i = 0; i < N; i++) {
                konto.wplata(KWOTA);
            }
        });

        Thread wyplacacz = new Thread(() -> {
            for(int i = 0; i < N; i++) {
                try {
                    konto.wyplata(KWOTA);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        });

        System.out.println("Uruchamiam wątki");
        wplacacz.start();
        wyplacacz.start();

        System.out.println("Czekam na zakończenie");
        try {
            wplacacz.join();
            wyplacacz.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Wątki zakończone, konto na końcu:");
        System.out.println(konto);

    }

    public int getSaldo(){
        main(null);
        return konto.getSaldo();
    }

}