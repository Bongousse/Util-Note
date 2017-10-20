package excel.domain;

public class BxmColumnDto {
	private String packageName;
	private String ommName;
	private String superType;
	private String ommDescription;
	private String type;
	private String name;
	private String description;
	private String length;
	private String decimal;
	private String arrayReference;
	private String align;
	private String fill;
	private String formatType;
	private String format;
	private String locale;
	private String referenceType;
	private String comment;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BxmColumnDto [packageName=");
		builder.append(packageName);
		builder.append(", ommName=");
		builder.append(ommName);
		builder.append(", superType=");
		builder.append(superType);
		builder.append(", ommDescription=");
		builder.append(ommDescription);
		builder.append(", type=");
		builder.append(type);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", length=");
		builder.append(length);
		builder.append(", decimal=");
		builder.append(decimal);
		builder.append(", arrayReference=");
		builder.append(arrayReference);
		builder.append(", align=");
		builder.append(align);
		builder.append(", fill=");
		builder.append(fill);
		builder.append(", formatType=");
		builder.append(formatType);
		builder.append(", format=");
		builder.append(format);
		builder.append(", locale=");
		builder.append(locale);
		builder.append(", referenceType=");
		builder.append(referenceType);
		builder.append(", comment=");
		builder.append(comment);
		builder.append("]");
		return builder.toString();
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getOmmName() {
		return ommName;
	}

	public void setOmmName(String ommName) {
		this.ommName = ommName;
	}

	public String getSuperType() {
		return superType;
	}

	public void setSuperType(String superType) {
		this.superType = superType;
	}

	public String getOmmDescription() {
		return ommDescription;
	}

	public void setOmmDescription(String ommDescription) {
		this.ommDescription = ommDescription;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getDecimal() {
		return decimal;
	}

	public void setDecimal(String decimal) {
		this.decimal = decimal;
	}

	public String getArrayReference() {
		return arrayReference;
	}

	public void setArrayReference(String arrayReference) {
		this.arrayReference = arrayReference;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getFill() {
		return fill;
	}

	public void setFill(String fill) {
		this.fill = fill;
	}

	public String getFormatType() {
		return formatType;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
