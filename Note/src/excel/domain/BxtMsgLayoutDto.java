package excel.domain;

import java.util.Arrays;

public class BxtMsgLayoutDto {

	private String layoutId;
	private String layoutNm;
	private String layoutDesc;
	private String catClcf;
	private byte[] layoutData;
	private String regUserId;
	private String regDttm;
	private String lastUpdtUserId;
	private String lastUpdtDttm;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BxtMsgLayoutDto [layoutId=");
		builder.append(layoutId);
		builder.append(", layoutNm=");
		builder.append(layoutNm);
		builder.append(", layoutDesc=");
		builder.append(layoutDesc);
		builder.append(", catClcf=");
		builder.append(catClcf);
		builder.append(", layoutData=");
		builder.append(Arrays.toString(layoutData));
		builder.append(", regUserId=");
		builder.append(regUserId);
		builder.append(", regDttm=");
		builder.append(regDttm);
		builder.append(", lastUpdtUserId=");
		builder.append(lastUpdtUserId);
		builder.append(", lastUpdtDttm=");
		builder.append(lastUpdtDttm);
		builder.append("]");
		return builder.toString();
	}

	public String getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}

	public String getLayoutNm() {
		return layoutNm;
	}

	public void setLayoutNm(String layoutNm) {
		this.layoutNm = layoutNm;
	}

	public String getLayoutDesc() {
		return layoutDesc;
	}

	public void setLayoutDesc(String layoutDesc) {
		this.layoutDesc = layoutDesc;
	}

	public String getCatClcf() {
		return catClcf;
	}

	public void setCatClcf(String catClcf) {
		this.catClcf = catClcf;
	}

	public byte[] getLayoutData() {
		return layoutData;
	}

	public void setLayoutData(byte[] layoutData) {
		this.layoutData = layoutData;
	}

	public String getRegUserId() {
		return regUserId;
	}

	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}

	public String getRegDttm() {
		return regDttm;
	}

	public void setRegDttm(String regDttm) {
		this.regDttm = regDttm;
	}

	public String getLastUpdtUserId() {
		return lastUpdtUserId;
	}

	public void setLastUpdtUserId(String lastUpdtUserId) {
		this.lastUpdtUserId = lastUpdtUserId;
	}

	public String getLastUpdtDttm() {
		return lastUpdtDttm;
	}

	public void setLastUpdtDttm(String lastUpdtDttm) {
		this.lastUpdtDttm = lastUpdtDttm;
	}
}
