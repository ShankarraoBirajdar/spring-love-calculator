package com.shankar.lc.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.lc.PropertyEditor.NamePropertyEditor;
import com.shankar.lc.Validator.EmailValidator;
import com.shankar.lc.Validator.UserNameValidator;
import com.shankar.lc.dto.Communication;
import com.shankar.lc.dto.Phone;
import com.shankar.lc.dto.RegistrationDTO;

import javax.validation.Valid;

@Controller
public class RegistrationController {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	EmailValidator emailValidator;
	
	@RequestMapping("/register")
	public String showRegistration(@ModelAttribute("registrationDTO") RegistrationDTO registrationDTO  ) {
		logger.info("Inside RegistrationController->showRegistration()");
		
		Phone phone = new Phone();
		phone.setCountryCode("+91");
		phone.setPhoneNumber("8208791702");
		
		Communication communication =new Communication();
		communication.setPhone(phone);
		
		registrationDTO.setCommunication(communication);
		
		return "User-Registration-Page";
	}
	
	@RequestMapping("/registration-success")
	public String processUserReg(@Valid @ModelAttribute("registrationDTO") RegistrationDTO registration, BindingResult result ) {
		logger.info("Inside RegistrationController->processUserReg()");
		
//		EmailValidator emailValidator = new EmailValidator(); #Autowired
		emailValidator.validate(registration, result);
		
		
		//printing values
		logger.info("name: "+registration.getName());
		logger.info("username: "+registration.getUsername());
		logger.info("Password: "+Arrays.toString(registration.getPassword()));
		logger.info("Country: "+registration.getCountry());
		logger.info("Hobbies: "+Arrays.toString(registration.getHoobies()));
		logger.info("Gender: "+registration.getGender());
		logger.info("Age: "+registration.getAge());
		logger.info("Email: "+registration.getCommunication().getEmail());
		logger.info("Phone: "+registration.getCommunication().getPhone());
		
		
		
		if (result.hasErrors()) {
			logger.info("Registration has errors..");
			 
		List<ObjectError> errors = result.getAllErrors();
		
		for (ObjectError objectError : errors) {
			logger.info("Error=>: "+objectError);
		}
			
			return "User-Registration-Page";
		}
		return "RegistrationSuccess";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		logger.info("Inside RegistrationController->initBinder()");
		
		//if you do not want to bind any object or field with DTO then use below command
		dataBinder.setDisallowedFields("name"); //Disallowed Fields name should be match with DTO
		
		//Custom Editor for user name field - remove whitespace and set null
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class,"username", editor);
		
		//Custom Editor for user name field - convert into Upper case
		NamePropertyEditor namePropertyEditor = new NamePropertyEditor();
		dataBinder.registerCustomEditor(String.class,"username", namePropertyEditor);
		
		//Register Custom Validator for user name Field
		UserNameValidator userNameValidator = new UserNameValidator();
		dataBinder.addValidators(userNameValidator);
		
		//Register Custom Validator for email Field
//		dataBinder.addValidators(new EmailValidator()); - object created at line no 54
	}
}
