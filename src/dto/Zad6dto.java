package dto;

import java.util.List;

import model.Akcija;
import model.Komponenta;

public class Zad6dto {
	
	private Akcija akcija;
	private List<Komponenta> lisKomp;
	
	
	public Akcija getAkcija() {
		return akcija;
	}


	public void setAkcija(Akcija akcija) {
		this.akcija = akcija;
	}


	public List<Komponenta> getLisKomp() {
		return lisKomp;
	}


	public void setLisKomp(List<Komponenta> lisKomp) {
		this.lisKomp = lisKomp;
	}


	public Zad6dto() {
		
		
		
		// TODO Auto-generated constructor stub
	}

}
