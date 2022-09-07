package com.jpaa.mastercard.mc.services.model.validator;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ValidZipCode, String> {

	@Override
	public void initialize(ValidZipCode constraintAnnotation) {
	}

	@Override
	public boolean isValid(String zipcode, ConstraintValidatorContext constraintValidatorContext) {
		return !Objects.isNull(zipcode) ? zipcode.matches("(^\\d{5}$)|(^\\d{9}$)|(^\\d{5}-\\d{4}$)") : false;
	}

}
