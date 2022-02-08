package dto;

import java.util.List;

import model.Akcija;
import model.Komponenta;
import model.Konfiguracija;
import model.Racunar;

public class Zad4dto {
	private Komponenta komponenta;
	private List<Konfiguracija> konfiguracije;
	private List<Racunar> racunari;
	private Akcija akcija;
	
	public int brojRac() {
		List<Racunar> racunari = this.getRacunari();
		int x=0;
		for(Racunar r:racunari) {
			x++;
		}
		
		return x;
		
	}
	

	public Akcija getAkcija() {
		return akcija;
	}


	public void setAkcija(Akcija akcija) {
		this.akcija = akcija;
	}


	public Komponenta getKomponenta() {
		return komponenta;
	}


	public void setKomponenta(Komponenta komponenta) {
		this.komponenta = komponenta;
	}


	public List<Konfiguracija> getKonfiguracije() {
		return konfiguracije;
	}


	public void setKonfiguracije(List<Konfiguracija> konfiguracije) {
		this.konfiguracije = konfiguracije;
	}


	public List<Racunar> getRacunari() {
		return racunari;
	}


	public void setRacunari(List<Racunar> racunari) {
		this.racunari = racunari;
	}


	public Zad4dto() {
		// TODO Auto-generated constructor stub
	}

}
