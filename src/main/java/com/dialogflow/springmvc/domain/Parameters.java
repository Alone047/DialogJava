package com.dialogflow.springmvc.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parameters {
	private String company;
	private Date iDate;

	public String getCompany() {
		return company;
	}

	public void setCompany(String input) {
		this.company = input;
	}

	@JsonProperty(value="iDate")
	public Date getIDate() {
		return iDate;
	}

	public void setIDate(Date date) {
		this.iDate = date;
	}

}
