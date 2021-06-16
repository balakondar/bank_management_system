package com.cts.bms.customer.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cts.bms.customer.entity.Customer;

import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer>{
	
	Mono<Customer> findByUsernameAndPassword(String username, String password);

}
