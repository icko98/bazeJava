package model;

public class Konfiguracija {
	private int IDR;
	private int IDK;
	private int KOMADA;
	

	@Override
	public String toString() {
		return "Konfiguracija [IDR=" + IDR + ", IDK=" + IDK + ", KOMADA=" + KOMADA + "]";
	}


	public Konfiguracija(int iDR, int iDK, int kOMADA) {
		super();
		IDR = iDR;
		IDK = iDK;
		KOMADA = kOMADA;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IDK;
		result = prime * result + IDR;
		result = prime * result + KOMADA;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Konfiguracija other = (Konfiguracija) obj;
		if (IDK != other.IDK)
			return false;
		if (IDR != other.IDR)
			return false;
		if (KOMADA != other.KOMADA)
			return false;
		return true;
	}


	public int getIDR() {
		return IDR;
	}


	public void setIDR(int iDR) {
		IDR = iDR;
	}


	public int getIDK() {
		return IDK;
	}


	public void setIDK(int iDK) {
		IDK = iDK;
	}


	public int getKOMADA() {
		return KOMADA;
	}


	public void setKOMADA(int kOMADA) {
		KOMADA = kOMADA;
	}


	public Konfiguracija() {
		// TODO Auto-generated constructor stub
	}

}
