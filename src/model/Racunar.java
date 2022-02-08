package model;

public class Racunar {
	private int IDR;
	private String NAZIVR;

	@Override
	public String toString() {
		return "Racunar [IDR=" + IDR + ", NAZIVR=" + NAZIVR + "]";
	}

	public Racunar(int iDR, String nAZIVR) {
		super();
		IDR = iDR;
		NAZIVR = nAZIVR;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IDR;
		result = prime * result + ((NAZIVR == null) ? 0 : NAZIVR.hashCode());
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
		Racunar other = (Racunar) obj;
		if (IDR != other.IDR)
			return false;
		if (NAZIVR == null) {
			if (other.NAZIVR != null)
				return false;
		} else if (!NAZIVR.equals(other.NAZIVR))
			return false;
		return true;
	}

	public int getIDR() {
		return IDR;
	}

	public void setIDR(int iDR) {
		IDR = iDR;
	}

	public String getNAZIVR() {
		return NAZIVR;
	}

	public void setNAZIVR(String nAZIVR) {
		NAZIVR = nAZIVR;
	}

	public Racunar() {
		// TODO Auto-generated constructor stub
	}

}
