package model;

public class Akcija {
	private int IDA;
	private int POPUST;
	private String NAZIVA;

	@Override
	public String toString() {
		return "Akcija [IDA=" + IDA + ", POPUST=" + POPUST + ", NAZIVA=" + NAZIVA + "]";
	}

	public Akcija(int iDA, int pOPUST, String nAZIVA) {
		super();
		IDA = iDA;
		POPUST = pOPUST;
		NAZIVA = nAZIVA;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IDA;
		result = prime * result + ((NAZIVA == null) ? 0 : NAZIVA.hashCode());
		result = prime * result + POPUST;
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
		Akcija other = (Akcija) obj;
		if (IDA != other.IDA)
			return false;
		if (NAZIVA == null) {
			if (other.NAZIVA != null)
				return false;
		} else if (!NAZIVA.equals(other.NAZIVA))
			return false;
		if (POPUST != other.POPUST)
			return false;
		return true;
	}

	public int getIDA() {
		return IDA;
	}

	public void setIDA(int iDA) {
		IDA = iDA;
	}

	public int getPOPUST() {
		return POPUST;
	}

	public void setPOPUST(int pOPUST) {
		POPUST = pOPUST;
	}

	public String getNAZIVA() {
		return NAZIVA;
	}

	public void setNAZIVA(String nAZIVA) {
		NAZIVA = nAZIVA;
	}

	public Akcija() {
		// TODO Auto-generated constructor stub
	}

}
