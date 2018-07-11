package com.dialogflow.springmvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryResult {
	private String queryText; 
	  private Parameters parameters; 
	  private boolean allRequiredParamsPresent;
	  private int intentDetectionConfidence; 
	  private String languageCode; 

	  public String getQueryText(){
	  	return queryText; 
	  }
	  public void setQueryText(String input){
	  	 this.queryText = input;
	  }
	  public Parameters getParameters(){
	  	return parameters; 
	  }
	  public void setParameters(Parameters input){
	  	 this.parameters = input;
	  }
	  public boolean getAllRequiredParamsPresent(){
	  	return allRequiredParamsPresent; 
	  }
	  public void setAllRequiredParamsPresent(boolean input){
	  	 this.allRequiredParamsPresent = input;
	  }
	  public int getIntentDetectionConfidence(){
	  	return intentDetectionConfidence; 
	  }
	  public void setIntentDetectionConfidence(int input){
	  	 this.intentDetectionConfidence = input;
	  }
	  public String getLanguageCode(){
	  	return languageCode; 
	  }
	  public void setLanguageCode(String input){
	  	 this.languageCode = input;
	  }
}

