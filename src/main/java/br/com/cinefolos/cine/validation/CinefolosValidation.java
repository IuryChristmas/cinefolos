package br.com.cinefolos.cine.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.cinefolos.cine.models.User;


public class CinefolosValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "field.required");
	    ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
	    		
	}

}
