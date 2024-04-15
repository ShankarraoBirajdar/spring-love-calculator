package com.shankar.lc.dto;

import java.util.logging.Logger;

public class Phone {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private String countryCode;
	private String phoneNumber;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		logger.info("Inside Phone->setCountryCode()");
		this.countryCode = countryCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		logger.info("Inside Phone->setPhoneNumber()");
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return countryCode + "-" + phoneNumber;
	}
		
}
