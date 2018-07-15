package br.com.producerconsumer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.producerconsumer.client.domain.Employee;
import br.com.producerconsumer.service.ConsumerClientService;

@RestController
@RequestMapping("/api")
public class ConsumerClientProducerController {

	@Autowired
	private ConsumerClientService consumerClientService;
	
	@GetMapping("/consumer")
	public ResponseEntity<Employee> get(){
		return ResponseEntity.status(HttpStatus.OK).body(consumerClientService.getEmployee());
	}
}
