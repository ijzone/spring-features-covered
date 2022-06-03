package com.features.customer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Person {

	private Long id;
	private String name;
	private int age;
	@Setter
	private int errorCount;

	public Person() {}
	
	public Person(Long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
}
