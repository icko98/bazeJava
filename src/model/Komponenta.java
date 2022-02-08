package model;
public class Komponenta {
	@Override
	public String toString() {
		return "Komponenta [IDK=" + IDK + ", NAZIVK=" + NAZIVK + ", TIP=" + TIP 
				+  "]";
	}
	private int IDK;
	private String NAZIVK;
	private String TIP;
	private String PROIZVODJAC;
	private int CENA;
	private int AKC;
	public Komponenta(int iDK, String nAZIVK, String tIP, String pROIZVODJAC, int cENA, int aKC) {
		super();
		IDK = iDK;
		NAZIVK = nAZIVK;
		TIP = tIP;
		PROIZVODJAC = pROIZVODJAC;
		CENA = cENA;
		AKC = aKC;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AKC;
		result = prime * result + CENA;
		result = prime * result + IDK;
		result = prime * result + ((NAZIVK == null) ? 0 : NAZIVK.hashCode());
		result = prime * result + ((PROIZVODJAC == null) ? 0 : PROIZVODJAC.hashCode());
		result = prime * result + ((TIP == null) ? 0 : TIP.hashCode());
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
		Komponenta other = (Komponenta) obj;
		if (AKC != other.AKC)
			return false;
		if (CENA != other.CENA)
			return false;
		if (IDK != other.IDK)
			return false;
		if (NAZIVK == null) {
			if (other.NAZIVK != null)
				return false;
		} else if (!NAZIVK.equals(other.NAZIVK))
			return false;
		if (PROIZVODJAC == null) {
			if (other.PROIZVODJAC != null)
				return false;
		} else if (!PROIZVODJAC.equals(other.PROIZVODJAC))
			return false;
		if (TIP == null) {
			if (other.TIP != null)
				return false;
		} else if (!TIP.equals(other.TIP))
			return false;
		return true;
	}
	public int getIDK() {
		return IDK;
	}
	public void setIDK(int iDK) {
		IDK = iDK;
	}
	public String getNAZIVK() {
		return NAZIVK;
	}
	public void setNAZIVK(String nAZIVK) {
		NAZIVK = nAZIVK;
	}
	public String getTIP() {
		return TIP;
	}
	public void setTIP(String tIP) {
		TIP = tIP;
	}
	public String getPROIZVODJAC() {
		return PROIZVODJAC;
	}
	public void setPROIZVODJAC(String pROIZVODJAC) {
		PROIZVODJAC = pROIZVODJAC;
	}
	public int getCENA() {
		return CENA;
	}
	public void setCENA(int cENA) {
		CENA = cENA;
	}
	public int getAKC() {
		return AKC;
	}
	public void setAKC(int aKC) {
		AKC = aKC;
	}
}

	
