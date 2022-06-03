package com.features.validation.person;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.features.customer.model.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonValidationServiceImpl implements PersonValidationService {

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

		if (p.getAge() < 0) {
			errors.rejectValue("age", "negativevalue");
		} else if(p.getAge() > 110) {
			errors.rejectValue("age", "too.darn.old");
		} 

		if(!this.isAllowed(p)) {
			errors.rejectValue("age", "underage");
		}

		if (errors.hasErrors()) {
			p.setErrorCount(errors.getErrorCount());
			log.error("Error Count: {}", errors.getErrorCount());
			log.error("{}", errors.getAllErrors());
		}

		log.info("##### Validation.validate end #####");
	}

	@Override
	public boolean isAllowed(Person person) {
		if(person.getAge() < 30) {
			return false;
		}
		return true;
	}

	@Override
	public Long execution(Object target) {
		boolean supportable = this.supports(target.getClass());
		if(!supportable) {
			return 0L;
		}
		
		this.validate(target, new BindException(target, "person"));
		
		Person person = (Person) target;
		
		return person.getId();
	}

}
