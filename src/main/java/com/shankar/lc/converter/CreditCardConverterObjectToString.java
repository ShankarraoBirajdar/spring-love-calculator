package com.shankar.lc.converter;

import java.util.logging.Logger;

import org.springframework.core.convert.converter.Converter;

import com.shankar.lc.dto.CreditCard;

public class CreditCardConverterObjectToString implements Converter<CreditCard, String> {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public String convert(CreditCard source) {
		logger.info("Inside CreditCardConverterObjectToString->convert()");
		// TODO Auto-generated method stub
		return source.getFirstFourDigit()+"-xxxx-xxxx-"+source.getLastFourDigit();
	}

}
