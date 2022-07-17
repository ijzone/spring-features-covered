package com.features.validation.sample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/validator")
public class Validation implements Validator {

	@RequestMapping
	public ResponseEntity<Person> executor() {
		Person person = new Person("ij", 120);
		Errors errors = new BindException(person, "person");
		
		Validation validation = new Validation();
		validation.supports(person.getClass());
		validation.validate(person, errors);
		
		if(errors.hasErrors()) {
			return new ResponseEntity<>(person, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(person, HttpStatus.OK);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		log.info("##### Validation.validate start #####");
		
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
		Person p = (Person) target;
		
		log.debug("Name: {} / Age: {}", p.getName(), p.getAge());
		
		if(p.getAge() < 0) {
			errors.rejectValue("age", "negativevalue");
		}else if(p.getAge() > 110) {
			errors.rejectValue("age", "too.darn.old");
		}
		
		if(errors.hasErrors()) {
			p.setErrorCount(errors.getErrorCount());
			p.setAllErrorMessages(errors.getAllErrors().toString());
			log.error("Error Count: {}", errors.getErrorCount());
			log.error("{}", errors.getAllErrors());
		}
		
		log.info("##### Validation.validate end #####");
	}
	
	@Getter
	static class Person {
		private String name;
		private int age;
		@Setter
		private int errorCount;
		@Setter
		private String allErrorMessages;
		
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
			this.errorCount = 0;
		}
	}
}
