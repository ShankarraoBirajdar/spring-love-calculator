package com.shankar.lc.dto;

import java.math.BigDecimal;

import java.util.Currency;
import java.util.Date;
import java.util.logging.Logger;

import lombok.Data;


public class BillDTO {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	private CreditCard creditCard;
	private Currency currency;
	private BigDecimal amount;
	private Date date;
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		logger.info("Inside BillDTO->setCreditCard()");
		this.creditCard = creditCard;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		logger.info("Inside BillDTO->setCurrency()");
		this.currency = currency;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		logger.info("Inside BillDTO->setAmount()");
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		logger.info("Inside BillDTO->setDate()");
		this.date = date;
	}
	@Override
	public String toString() {
		return "BillDTO [creditCard=" + creditCard + ", currency=" + currency + ", amount=" + amount + ", date=" + date
				+ "]";
	}

}
