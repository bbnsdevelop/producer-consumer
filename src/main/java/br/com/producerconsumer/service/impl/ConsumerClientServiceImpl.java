package br.com.producerconsumer.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import br.com.producerconsumer.client.ConsumerControllerClient;
import br.com.producerconsumer.client.domain.Employee;
import br.com.producerconsumer.service.ConsumerClientService;

@Service
public class ConsumerClientServiceImpl implements ConsumerClientService{

	@Autowired
	private ConsumerControllerClient consumerControllerClient;
	
	@Override
	public Employee getEmployee() {
		Employee employee = new Employee();
		try {
			employee = consumerControllerClient.getEmployee();
		} catch (RestClientException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

}
