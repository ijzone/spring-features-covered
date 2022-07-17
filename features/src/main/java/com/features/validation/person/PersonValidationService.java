package com.features.validation.person;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.features.customer.model.Person;

public interface PersonValidationService extends Validator {

	/**
	 * 유효 나이 검증
	 * @param person
	 * @param Errors
	 */
	void isAllowedAge(Person person, Errors errors);
	
	/**
	 * 검증 메서드 실행
	 * @param target
	 * @return
	 */
	Long execution(Object target);
}
