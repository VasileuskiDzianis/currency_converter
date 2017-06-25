package by.learning.extapi.domain;

import java.util.Date;

public class Currency {
	private int id;
	private int parentId;

	private String code;
	private String abbreviation;

	private String nameRus;
	private String nameBel;
	private String nameEng;

	private String quotNameRus;
	private String quotNameBel;
	private String quotNameEng;

	private String nameMultiRus;
	private String nameMultiBel;
	private String nameMultiEng;

	private int scale;
	private int periodicity;

	private Date inclusionDate;
	private Date exclusionDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getNameRus() {
		return nameRus;
	}

	public void setNameRus(String nameRus) {
		this.nameRus = nameRus;
	}

	public String getNameBel() {
		return nameBel;
	}

	public void setNameBel(String nameBel) {
		this.nameBel = nameBel;
	}

	public String getNameEng() {
		return nameEng;
	}

	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}

	public String getQuotNameRus() {
		return quotNameRus;
	}

	public void setQuotNameRus(String quotNameRus) {
		this.quotNameRus = quotNameRus;
	}

	public String getQuotNameBel() {
		return quotNameBel;
	}

	public void setQuotNameBel(String quotNameBel) {
		this.quotNameBel = quotNameBel;
	}

	public String getQuotNameEng() {
		return quotNameEng;
	}

	public void setQuotNameEng(String quotNameEng) {
		this.quotNameEng = quotNameEng;
	}

	public String getNameMultiRus() {
		return nameMultiRus;
	}

	public void setNameMultiRus(String nameMultiRus) {
		this.nameMultiRus = nameMultiRus;
	}

	public String getNameMultiBel() {
		return nameMultiBel;
	}

	public void setNameMultiBel(String nameMultiBel) {
		this.nameMultiBel = nameMultiBel;
	}

	public String getNameMultiEng() {
		return nameMultiEng;
	}

	public void setNameMultiEng(String nameMultiEng) {
		this.nameMultiEng = nameMultiEng;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(int periodicity) {
		this.periodicity = periodicity;
	}

	public Date getInclusionDate() {
		return inclusionDate;
	}

	public void setInclusionDate(Date inclusionDate) {
		this.inclusionDate = inclusionDate;
	}

	public Date getExclusionDate() {
		return exclusionDate;
	}

	public void setExclusionDate(Date exclusionDate) {
		this.exclusionDate = exclusionDate;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", parentId=" + parentId + ", code=" + code + ", abbreviation=" + abbreviation
				+ ", nameRus=" + nameRus + ", nameBel=" + nameBel + ", nameEng=" + nameEng + ", quotNameRus="
				+ quotNameRus + ", quotNameBel=" + quotNameBel + ", quotNameEng=" + quotNameEng + ", nameMultiRus="
				+ nameMultiRus + ", nameMultiBel=" + nameMultiBel + ", nameMultiEng=" + nameMultiEng + ", scale="
				+ scale + ", periodicity=" + periodicity + ", inclusionDate=" + inclusionDate + ", exclusionDate="
				+ exclusionDate + "]";
	}
}
