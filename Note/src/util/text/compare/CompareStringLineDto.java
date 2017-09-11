package util.text.compare;

public class CompareStringLineDto {
	private String compTypeCd;
	private String strA;
	private String strB;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompareStringLineDto [compTypeCd=");
		builder.append(compTypeCd);
		builder.append(", strA=");
		builder.append(strA);
		builder.append(", strB=");
		builder.append(strB);
		builder.append("]");
		return builder.toString();
	}

	public String getCompTypeCd() {
		return compTypeCd;
	}

	public void setCompTypeCd(String compTypeCd) {
		this.compTypeCd = compTypeCd;
	}

	public String getStrA() {
		return strA;
	}

	public void setStrA(String strA) {
		this.strA = strA;
	}

	public String getStrB() {
		return strB;
	}

	public void setStrB(String strB) {
		this.strB = strB;
	}

}
