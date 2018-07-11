package com.dialogflow.springmvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dialogflow {
	private String responseId;
	private QueryResult queryResult;
	private String session;

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String input) {
		this.responseId = input;
	}

	public QueryResult getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(QueryResult input) {
		this.queryResult = input;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String input) {
		this.session = input;
	}
}