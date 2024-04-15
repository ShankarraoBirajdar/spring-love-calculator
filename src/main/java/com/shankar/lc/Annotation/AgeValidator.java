package com.shankar.lc.Annotation;

import java.util.logging.Logger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class AgeValidator implements ConstraintValidator<Age, Integer> {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private int lower;
	private int upper;
	
	@Override
	public void initialize(Age age) {
		logger.info("Inside AgeValidator->initialize()");
		this.lower = age.lower();
		this.upper = age.upper();
	}

	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		logger.info("Inside AgeValidator->isValid()");
		if (age==null) {
			return false;
		}
		
		if (age<lower || age>upper) {
			return false;
		}
		return true;
	}

}
