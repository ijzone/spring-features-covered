package com.features.validation.person;

import org.springframework.validation.Validator;

import com.features.customer.model.Person;

public interface PersonValidationService extends Validator {

	/**
	 * 유효 나이 검증
	 * @param person
	 * @return
	 */
	boolean isAllowed(Person person);
	
	/**
	 * 실행 메서드
	 * @param target
	 * @return
	 */
	Long execution(Object target);
}
