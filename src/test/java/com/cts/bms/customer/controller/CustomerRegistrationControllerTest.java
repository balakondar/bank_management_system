package com.cts.bms.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import com.cts.bms.customer.service.CustomerRegistrationService;

import reactor.core.publisher.Mono;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerRegistrationControllerTest {

	@Autowired
    private WebTestClient webClient;
	
	@Autowired
	CustomerRegistrationService customerRegistrationService;
	
	@Test
    public void findCustomerIdTest() {
		
		Mono<Boolean> monoBoolean=Mono.just(true);
		
		Mockito.when(customerRegistrationService.findbyCustomerId(5)).thenReturn(monoBoolean);
    	
        webClient.get().uri("/Customer/{customerId}",5)
        		.exchange()
		        .expectStatus().isOk()
		        .expectBody(Boolean.class)
		        .isEqualTo(true);
    }

}
