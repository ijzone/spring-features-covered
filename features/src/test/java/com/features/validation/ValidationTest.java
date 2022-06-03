package com.features.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

import com.features.validation.Validation.Person;

class ValidationTest {

	@Test
	void 스프링_Validator_테스트() {
		Validation validation = new Validation();
		Validation.Person person = new Person("ij", 120);
		Errors errors = new BindException(person, "person");
		
		validation.validate(person, errors);
		
		assertThat(person.getErrorCount()).isEqualTo(0);
	}

}
