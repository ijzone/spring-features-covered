package com.features.validation.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.features.customer.model.Person;
import com.features.customer.model.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/person")
public class PersonValidationController {

	private final PersonValidationService service;
	
	@Autowired
	public PersonValidationController(PersonValidationService service) {
		this.service = service;
	}
	
	@RequestMapping
	public String process() {
		Person person1 = new Person(123L, "ij", 35);
		Product product1 = new Product(1L, "product");
		
//		boolean supports1 = service.supports(person1.getClass());
//		log.info("### person1 SUPPORTS : {}", supports1);
//		
//		boolean supports2 = service.supports(product1.getClass());
//		log.info("### product1 SUPPORTS : {}", supports2);
		
		Long personId = service.execution(person1);
		log.info("### personId: {}", personId);
		
		return "OK";
	}
	
}
