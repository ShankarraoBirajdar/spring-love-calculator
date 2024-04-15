package com.shankar.lc.Validator;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shankar.lc.dto.RegistrationDTO;

@Component
public class EmailValidator  implements Validator {

	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public boolean supports(Class<?> clazz) {
		logger.info("Inside EmailValidator->supports()");
		return RegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("Inside EmailValidator->validate()");
		
		//To check if the field is null
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communication.email","email.empty");
		
		//wheather email ending with @gmail.com
		
		String email = ((RegistrationDTO)target).getCommunication().getEmail();
		
		if (!email.endsWith("@gmail.com")) {
			errors.rejectValue("communication.email", "email.invalidDomain");
		}
		
	}

}
