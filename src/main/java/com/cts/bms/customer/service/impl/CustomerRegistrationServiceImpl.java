package com.cts.bms.customer.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bms.customer.entity.Customer;
import com.cts.bms.customer.repo.CustomerRepository;
import com.cts.bms.customer.service.CustomerRegistrationService;

import reactor.core.publisher.Mono;

@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

	private static final Logger log = LoggerFactory.getLogger(CustomerRegistrationServiceImpl.class);
	@Autowired
	private CustomerRepository customerRepository;


	@Override
	public Mono<Customer> registerCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Mono<Customer> viewCustomer(Customer customer) {
		log.info("Customer User :"+customer.getUsername());
		return customerRepository.findByUsernameAndPassword(customer.getUsername(), customer.getPassword());
	}
	
	@Override
	public Mono<Boolean> findbyCustomerId(Integer customerId) {
		log.info("Customer customerId :"+customerId);
		Mono<Boolean> customer= customerRepository.findById(customerId).map(found -> true).switchIfEmpty(Mono.just(false));;
		log.info("Customer:"+customer);
		return customer;	
		
	}

}
