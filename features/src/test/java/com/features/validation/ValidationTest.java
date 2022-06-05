package com.features.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.features.customer.model.Person;
import com.features.validation.person.PersonValidationService;
import com.features.validation.person.PersonValidationServiceImpl;

class ValidationTest {

	private PersonValidationService service = new PersonValidationServiceImpl();
	
	@Test
	void 스프링_Validator_테스트() {
		// given
		Person person = new Person(1L, "ij", 20);
		
		// when
		Long userId = service.execution(person);
		
		// then
		assertThat(userId).isEqualTo(-1L);
	}

}
