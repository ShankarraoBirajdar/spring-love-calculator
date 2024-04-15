package com.shankar.lc.formatter;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Logger;

import org.springframework.format.Formatter;

import com.shankar.lc.dto.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public String print(Phone phone, Locale locale) {
		logger.info("Inside PhoneNumberFormatter->print()");
		return phone.getCountryCode()+"-"+phone.getPhoneNumber();
	}

	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
		logger.info("Inside PhoneNumberFormatter->parse()");
		int index = completePhoneNumber.indexOf("-");
		boolean starts = completePhoneNumber.startsWith("-");
		boolean ends = completePhoneNumber.endsWith("-");
		
		if (starts || ends) {
			completePhoneNumber=completePhoneNumber.replace("-", "");
			logger.info("completePhoneNumber: "+completePhoneNumber);
		}
		String phoneNumberArr[] = completePhoneNumber.split("-");
		logger.info("phoneNumberArr[] "+ Arrays.toString(phoneNumberArr));
		Phone phone = new Phone();
		if (index==-1 || starts|| ends) {
			phone.setCountryCode("+91");
			phone.setPhoneNumber(phoneNumberArr[0]);
		}else {
			phone.setCountryCode(phoneNumberArr[0]);
			phone.setPhoneNumber(phoneNumberArr[1]);
		}
		

		return phone;
	}

}
