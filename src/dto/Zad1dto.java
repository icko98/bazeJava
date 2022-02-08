package dto;

import model.Racunar;

import java.util.List;

import model.Konfiguracija;

public class Zad1dto {
	private Racunar racunar;
	private List<Konfiguracija> konfiguracije;
	public Zad1dto() {
		// TODO Auto-generated constructor stub
	}
	public Racunar getRacunar() {
		return racunar;
	}
	public void setRacunar(Racunar racunar) {
		this.racunar = racunar;
	}
	public List<Konfiguracija> getKonfiguracije() {
		return konfiguracije;
	}
	public void setKonfiguracije(List<Konfiguracija> konfiguracije) {
		this.konfiguracije = konfiguracije;
	}
	
	

}
