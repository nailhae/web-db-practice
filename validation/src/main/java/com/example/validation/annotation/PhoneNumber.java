package com.example.validation.annotation;

import com.example.validation.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {PhoneNumberValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber{
	String message() default "Invalid phone number. ex) 010-1234-5678";

	String regexp() default "^\\d{3}-\\d{4}-\\d{4}$";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
