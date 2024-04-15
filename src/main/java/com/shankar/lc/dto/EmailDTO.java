package com.shankar.lc.dto;

import java.util.logging.Logger;

public class EmailDTO {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private String userEmail;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		logger.info("Inside EmailDTO->setUserEmail()");
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return userEmail;
	}
	
	
}
