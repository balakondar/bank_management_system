package com.cts.bms.customer.service;

import com.cts.bms.customer.entity.Customer;

import reactor.core.publisher.Mono;

public interface CustomerRegistrationService {
	
	Mono<Customer> registerCustomer(Customer customer);

	Mono<Customer> viewCustomer(Customer customer);
	
	Mono<Boolean> findbyCustomerId(Integer customerId);
	
}
