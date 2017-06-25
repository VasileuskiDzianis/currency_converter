package by.learning.extapi.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rate {
	@JsonProperty("Cur_ID")
	private int id;
	@JsonProperty("Date")
	private Date date;
	@JsonProperty("Cur_Abbreviation")
	private String abbreviation;
	@JsonProperty("Cur_Scale")
	private int scale;
	@JsonProperty("Cur_Name")
	private String name;
	@JsonProperty("Cur_OfficialRate")
	private BigDecimal officialRate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOfficialRate() {
		return officialRate;
	}

	public void setOfficialRate(BigDecimal officialRate) {
		this.officialRate = officialRate;
	}

	@Override
	public String toString() {
		return "Rate [id=" + id + ", date=" + date + ", abbreviation=" + abbreviation + ", scale=" + scale + ", name="
				+ name + ", officialRate=" + officialRate + "]";
	}

}
