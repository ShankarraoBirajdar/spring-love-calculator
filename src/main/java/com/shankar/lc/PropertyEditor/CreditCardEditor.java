package com.shankar.lc.PropertyEditor;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.logging.Logger;

import com.shankar.lc.dto.CreditCard;

public class CreditCardEditor extends PropertyEditorSupport {
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public String getAsText() {
		logger.info("Inside CreditCardEditor->getAsText()");
		CreditCard creditCard=(CreditCard)getValue();
		return creditCard.getFirstFourDigit()+"-xxxx-xxxx-"+creditCard.getLastFourDigit();
//		return "Enter in xxxx-xxxx-xxxx-xxxx format";
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		logger.info("Inside CreditCardEditor->setAsText()");

		String creditCardNumberArr[] = text.split("-");
		logger.info("creditCardNumberArr[] " + Arrays.toString(creditCardNumberArr));
		CreditCard creditCard = new CreditCard();

		creditCard.setFirstFourDigit(Integer.valueOf(creditCardNumberArr[0]));
		creditCard.setSecondFourDigit(Integer.valueOf(creditCardNumberArr[1]));
		creditCard.setThirdFourDigit(Integer.valueOf(creditCardNumberArr[2]));
		creditCard.setLastFourDigit(Integer.valueOf(creditCardNumberArr[3]));

		setValue(creditCard);
	}
}
