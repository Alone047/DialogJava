package com.dialogflow.springmvc.domain;

public class Response{
	  private String fulfillmentText; 
	  private String source; 

	  public Response(String text, String name) {
		// TODO Auto-generated constructor stub
		  	this.fulfillmentText = text;
	        this.source = name;
	}
	public String getFulfillmentText(){
	  	return fulfillmentText; 
	  }
	  public void setFulfillmentText(String input){
	  	 this.fulfillmentText = input;
	  }
	  public String getSource(){
	  	return source; 
	  }
	  public void setSource(String input){
	  	 this.source = input;
	  }
}

