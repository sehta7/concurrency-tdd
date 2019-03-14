package com.ja.app.synchronize;

/**
 * @author Ola Podorska
 */
class Konto {
	private final int numer;
	private int saldo;
	private Osoba wlasciciel;
	
	public Konto(int numer, int saldo, Osoba wlasciciel) {
		this.numer = numer;
		this.saldo = saldo;
		this.wlasciciel = wlasciciel;
	}
	
	public String toString() {
		return "Konto nr " + numer + ", saldo: " + saldo + ", wł.: " + wlasciciel;			
	}
	
	public void wplata(int kwota) {
		if(kwota < 0) {
			throw new IllegalArgumentException("Ujemna kwota " + kwota + " we wpłacie");
		}
		synchronized(this) {
			saldo += kwota;
			this.notify();
		}
	}

	public void wyplata(int kwota) throws Exception {
		if(kwota < 0) {
			throw new IllegalArgumentException("Ujemna kwota " + kwota + " w wypłacie");
		}
		synchronized(this) {
			if (kwota > saldo) {
				throw new Exception("Brak środków na koncie nr " + numer);
			}
			saldo -= kwota;
		}
	}
	
	public void wyplataCzekaj(int kwota) {
		if(kwota < 0) {
			throw new IllegalArgumentException("Ujemna kwota " + kwota + " w wypłacie");
		}
		
		synchronized(this) {
			while(kwota > saldo) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			saldo -= kwota;
			this.notify();
		}
	}

	public int getSaldo() {
		return saldo;
	}
}

