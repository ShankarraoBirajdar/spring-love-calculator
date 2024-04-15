package com.shankar.lc.dto;

import java.util.logging.Logger;

public class Communication {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private String email;
	private Phone phone;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		logger.info("Inside Communication->setEmail()");
		this.email = email;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		logger.info("Inside Communication->setPhone()");
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Communication [email=" + email + ", phone=" + phone + "]";
	}
}
