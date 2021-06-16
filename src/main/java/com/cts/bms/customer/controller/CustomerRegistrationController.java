package com.cts.bms.customer.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bms.customer.entity.Customer;
import com.cts.bms.customer.service.CustomerRegistrationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/Customer")
public class CustomerRegistrationController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerRegistrationController.class);
	
	@Autowired
	private CustomerRegistrationService customerRegistrationService;
	
	@Autowired
	PasswordEncoder encoder;	
	
	@PostMapping("/Register")
	public Mono<Customer> registerCustomer(@RequestBody Customer customer)
			throws URISyntaxException {
		customer.setPassword(encoder.encode(customer.getPassword()));
		return customerRegistrationService.registerCustomer(customer).doOnSuccess(cus -> log.info("Customer registered: accountno", cus.getAccountno()));
	}
	
	@GetMapping("/ViewCustomers")
	public Flux<Customer> viewCustomerDetails(){
		return customerRegistrationService.viewCustomers();
	}
	
	@GetMapping("/{customerId}")
	public Mono<Boolean> findCustomerId(@PathVariable Integer customerId)	 {
		log.info("Customer ID:"+ customerId);
		return customerRegistrationService.findbyCustomerId(customerId);
	}
	
}
