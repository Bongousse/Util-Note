package util.text.compare;

public class CompareStringLineDto {
	private String str;
	private String compTypeCd;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompareStringLineDto [str=");
		builder.append(str);
		builder.append(", compTypeCd=");
		builder.append(compTypeCd);
		builder.append("]");
		return builder.toString();
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getCompTypeCd() {
		return compTypeCd;
	}

	public void setCompTypeCd(String compTypeCd) {
		this.compTypeCd = compTypeCd;
	}

}
