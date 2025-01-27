package com.shankar.lc.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
	
	String message() default "{com.shankar.lc.Annotation.Age}";
	
	int lower() default 18;
	
	int upper() default 60;

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
