package com.learn.springdemo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	//define attibutes for course code
	public String value() default "LUV";
	
	//define default error message
	public String message() default "must strat with LUV";
	
	//define default groups
	public Class<?>[] groups() default {};
	
	//define defauklt payloads
	public Class<? extends Payload>[] payload() default {};
	
}
