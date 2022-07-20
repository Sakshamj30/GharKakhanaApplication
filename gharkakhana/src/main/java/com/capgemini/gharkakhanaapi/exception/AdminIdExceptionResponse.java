package com.capgemini.gharkakhanaapi.exception;

public class AdminIdExceptionResponse {

	private String mobileNumber;

	public AdminIdExceptionResponse(String mobileNumber)
	{
		super();
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
