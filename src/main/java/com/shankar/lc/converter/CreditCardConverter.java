package com.shankar.lc.converter;

import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.core.convert.converter.Converter;

import com.shankar.lc.dto.CreditCard;

public class CreditCardConverter implements Converter<String, CreditCard> {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public CreditCard convert(String source) {
		logger.info("Inside CreditCardConverter->convert()");

		String creditCardNumberArr[] = source.split("-");
		logger.info("creditCardNumberArr[] " + Arrays.toString(creditCardNumberArr));
		CreditCard creditCard = new CreditCard();

		creditCard.setFirstFourDigit(Integer.valueOf(creditCardNumberArr[0]));
		creditCard.setSecondFourDigit(Integer.valueOf(creditCardNumberArr[1]));
		creditCard.setThirdFourDigit(Integer.valueOf(creditCardNumberArr[2]));
		creditCard.setLastFourDigit(Integer.valueOf(creditCardNumberArr[3]));
		
		// TODO Auto-generated method stub
		return creditCard;
	}

}
