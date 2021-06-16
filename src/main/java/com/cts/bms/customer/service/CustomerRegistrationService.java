package com.cts.bms.customer.service;

import com.cts.bms.customer.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRegistrationService {
	
	Mono<Customer> registerCustomer(Customer customer);

	Flux<Customer> viewCustomers();
	
	Mono<Boolean> findbyCustomerId(Integer customerId);
	
}
