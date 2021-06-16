package com.cts.bms.customer.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cts.bms.customer.entity.Customer;

import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer>{
	
	Mono<Customer> findByUsernameAndPassword(String username, String password);

	//@Query("select cust FROM Customer cust where cust.customerid =:customerId")
	//Mono<Customer> findbyCustomerId(Integer custmerId);

}
