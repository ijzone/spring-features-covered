package com.features.validation.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.features.customer.model.Person;

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
	
	@GetMapping
	public ResponseEntity<Person> process(@RequestBody Person person) {
//		Person personEx = new Person(123L, "ij", 35);
//		Product productEx = new Product(1L, "product");
		
//		boolean supports1 = service.supports(person1.getClass());
//		log.info("### person1 SUPPORTS : {}", supports1);
//		
//		boolean supports2 = service.supports(product1.getClass());
//		log.info("### product1 SUPPORTS : {}", supports2);
		
		Long personId = service.execution(person);
		log.info("### personId: {}", personId);
		
		if(personId == -1L) {
//			return new ResponseEntity<Person>(person, HttpStatus.BAD_REQUEST);
			return ResponseEntity.badRequest().body(person);
		}
//		return new ResponseEntity<Person>(person, HttpStatus.OK);
		return ResponseEntity.ok(person);
	}
	
}
