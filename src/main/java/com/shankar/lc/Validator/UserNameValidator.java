package com.shankar.lc.Validator;

import java.util.logging.Logger;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shankar.lc.dto.RegistrationDTO;

public class UserNameValidator implements Validator {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	//Check if the UserNameValidator supports a given object
	@Override
	public boolean supports(Class<?> clazz) {
		logger.info("Inside UserNameValidator->supports()");
		
		return RegistrationDTO.class.equals(clazz);
	}

	//we need to write our custom validation logic
	@Override
	public void validate(Object target, Errors errors) {
		logger.info("Inside UserNameValidator->validate()");
		//To check if the field is null
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username","username.empty" , "User Name Can't be Empty");
		
		//The String should contain a _
		
		String userName = ((RegistrationDTO)target).getUsername();
		
		
		if (!userName.contains("_")) {
			logger.info("Inside UserNameValidator->validate()->contains()");
			errors.rejectValue("username", "username.invalidString","String must contain a '_' ");
		}

	}

}
