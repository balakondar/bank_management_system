package com.bms.account.service;

import org.junit.jupiter.api.Test;

import com.cts.bms.customer.entity.Customer;
import com.cts.bms.customer.service.impl.CustomerRegistrationServiceImpl;

import reactor.test.StepVerifier;

public class BmsServiceTests {

	CustomerRegistrationServiceImpl customerreg;
	
	
	@Test
	public void testRegisterEmployees() {
		
		Customer customer =getCustomer();
		StepVerifier
		.create(customerreg.registerCustomer(customer))
		.expectNext(customer)
		.expectComplete()
		.verify();		
	}
	
	@Test
	public void testViewEmployees() {
		
		Customer customer = getCustomer();
		
		StepVerifier
		.create(customerreg.registerCustomer(customer))
		.expectNext(customer)
		.expectComplete()
		.verify();	
		
		StepVerifier
		.create(customerreg.viewCustomer(customer))
		.expectNext(customer)
		.expectComplete()
		.verify();	
	}
	
	
	private Customer getCustomer() {
		Customer customer=new Customer();
		customer.setCustomerid(1);
		customer.setAccountno(123432);
		
		return customer;
	}
	

}
