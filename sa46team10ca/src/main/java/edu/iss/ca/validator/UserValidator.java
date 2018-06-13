package edu.iss.ca.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.iss.ca.models.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		User u = (User) target;	
		ValidationUtils.rejectIfEmpty(errors, "name", "error.user.name.empty");	
		ValidationUtils.rejectIfEmpty(errors, "nric", "error.user.nric.empty");	
		ValidationUtils.rejectIfEmpty(errors, "role", "error.user.role.empty");
		ValidationUtils.rejectIfEmpty(errors, "username", "error.user.username.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.user.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "dob", "error.user.dob.empty");
		ValidationUtils.rejectIfEmpty(errors, "phone", "error.user.phone.empty");
		ValidationUtils.rejectIfEmpty(errors, "address", "error.user.address.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.user.email.empty");
		System.out.println(u.toString());
	}	
	
}
