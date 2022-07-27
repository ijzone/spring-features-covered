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

		log.info("Name: {} / Age: {}", p.getName(), p.getAge());

		this.isAllowedAge(p, errors);

		if (errors.hasErrors()) {
			p.setErrorCount(errors.getErrorCount());
			p.setAllErrorMessages(errors.getAllErrors().toString());
		}

		log.info("##### Validation.validate end #####");
	}

	@Override
	public void isAllowedAge(Person p, Errors errors) {
		if(p.getAge() < 30) {
			if(p.getAge() < 0) {
				errors.rejectValue("age", "negativevalue");
			}else {
				errors.rejectValue("age", "underage");
			}
		} else if(p.getAge() > 110) {
			errors.rejectValue("age", "too.darn.old");
		}
	}

	@Override
	public Long execution(Object target) {
		boolean supportable = this.supports(target.getClass());
		if(!supportable) {
			return -1L;
		}
		
		Errors bindException = new BindException(target, "person");
		this.validate(target, bindException);
		
		Person person = (Person) target;
		if(bindException.hasErrors()) {
			log.error("bindException.getErrorCount(): {}", bindException.getErrorCount());
			return -1L;
		}
		
		return person.getId();
	}

	@Override
	public Person personInfo(Long id) {
		return null;
	}

}
