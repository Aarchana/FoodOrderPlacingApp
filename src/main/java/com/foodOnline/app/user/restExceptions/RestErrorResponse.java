package com.foodOnline.app.user.restExceptions;


import java.util.Date;


public class RestErrorResponse{
	private Date timeStamp = new Date();
	private int status;
	private String error;
	
	public RestErrorResponse( int status, String error) {
		super();
		this.status = status;
		this.error = error;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}
	
	
}
