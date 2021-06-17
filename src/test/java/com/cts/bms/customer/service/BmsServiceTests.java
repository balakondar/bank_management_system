package com.cts.bms.customer.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.bms.customer.entity.Customer;
import com.cts.bms.customer.repo.CustomerRepository;
import com.cts.bms.customer.service.impl.CustomerRegistrationServiceImpl;

import reactor.test.StepVerifier;

public class BmsServiceTests {
	
	CustomerRegistrationServiceImpl customerreg;
		
	@BeforeAll
	public static void setup() {
		System.out.println("Before All called...");
	}

	@BeforeEach
	public void setupTest() {
		System.out.println("Before Each called...");
		customerreg = new CustomerRegistrationServiceImpl();
		
	}
	
	
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
		/*
		 * StepVerifier .create(customerreg.viewCustomer()) .expectNext()
		 * .expectComplete() .verify();
		 */
	}
	
	@Test
	public void testfindbyCustomerId() {		

		StepVerifier
		.create(customerreg.findbyCustomerId(5))
		.expectNextCount(1)
		.expectComplete()
		.verify();			
	}
	
	
	private Customer getCustomer() {
		Customer customer=new Customer();
		customer.setCustomerid(5);
		customer.setAccountno(123432);
		customer.setUsername("Test1");
		customer.setPassword("$2a$10$RCpgTTq8UgE/lxfq2LivKuFEISNAz8oJefrAQUvjLXwiK0k18Gywq");
		customer.setEmail("abc@gmail.com");
		customer.setAddress("Colony 1");
		customer.setState("Telanga");
		customer.setCountry("India");
		customer.setPan("Kj7632NHD");
		customer.setContactno("9876987663");
		customer.setDob("01012000");
		customer.setAccounttype("Saving");
		
		return customer;
	}
	

}
