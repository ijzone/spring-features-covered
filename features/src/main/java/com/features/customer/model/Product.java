package com.features.customer.model;

import lombok.Getter;

@Getter
public class Product {

	private Long pid;
	private String productName;
	
	public Product(Long pid, String productName) {
		this.pid = pid;
		this.productName = productName;
	}
	
}
