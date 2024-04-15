package com.shankar.lc.dto;

import java.util.logging.Logger;

public class CreditCard {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private Integer firstFourDigit;
	private Integer secondFourDigit;
	private Integer thirdFourDigit;
	private Integer lastFourDigit;

	public Integer getFirstFourDigit() {
		return firstFourDigit;
	}

	public void setFirstFourDigit(Integer firstFourDigit) {
		logger.info("Inside CreditCard->setFirstFourDigit()");
		this.firstFourDigit = firstFourDigit;
	}

	public Integer getSecondFourDigit() {
		return secondFourDigit;
	}

	public void setSecondFourDigit(Integer secondFourDigit) {
		logger.info("Inside CreditCard->setSecondFourDigit()");
		this.secondFourDigit = secondFourDigit;
	}

	public Integer getThirdFourDigit() {
		return thirdFourDigit;
	}

	public void setThirdFourDigit(Integer thirdFourDigit) {
		logger.info("Inside CreditCard->setThirdFourDigit()");
		this.thirdFourDigit = thirdFourDigit;
	}

	public Integer getLastFourDigit() {
		return lastFourDigit;
	}

	public void setLastFourDigit(Integer lastFourDigit) {
		logger.info("Inside CreditCard->setLastFourDigit()");
		this.lastFourDigit = lastFourDigit;
	}

	@Override
	public String toString() {
		return firstFourDigit + "-" + secondFourDigit + "-" + thirdFourDigit + "-" + lastFourDigit;
	}

}
