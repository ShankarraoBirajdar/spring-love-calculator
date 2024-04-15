package com.shankar.lc.formatter;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Logger;

import org.springframework.format.Formatter;

import com.shankar.lc.dto.CreditCard;

public class CreditCardFormatter implements Formatter<CreditCard> {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public String print(CreditCard object, Locale locale) {
		logger.info("Inside CreditCardFormatter->print()");
		return null;
	}

	@Override
	public CreditCard parse(String completecreditCardNumber, Locale locale) throws ParseException {
		logger.info("Inside CreditCardFormatter->parse()");
		
		String creditCardNumberArr[] = completecreditCardNumber.split("-");
		logger.info("creditCardNumberArr[] "+ Arrays.toString(creditCardNumberArr));
		CreditCard creditCard = new CreditCard();
		
		creditCard.setFirstFourDigit(Integer.valueOf(creditCardNumberArr[0]));
		creditCard.setSecondFourDigit(Integer.valueOf(creditCardNumberArr[1]));
		creditCard.setThirdFourDigit(Integer.valueOf(creditCardNumberArr[2]));
		creditCard.setLastFourDigit(Integer.valueOf(creditCardNumberArr[3]));
		
		
		
		
		return creditCard;
	}

}
