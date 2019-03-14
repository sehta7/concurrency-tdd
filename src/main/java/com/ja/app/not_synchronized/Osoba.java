package com.ja.app.not_synchronized;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Ola Podorska
 */
class Osoba {
    private String imie, nazwisko;
    private LocalDate dataUrodzenia;

    public Osoba() {
    }

    Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Osoba(String imie, String nazwisko, LocalDate dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
    }

    @Override
    public String toString() {
        return imie + " " +nazwisko + " ur." + dataUrodzenia;
    }

}