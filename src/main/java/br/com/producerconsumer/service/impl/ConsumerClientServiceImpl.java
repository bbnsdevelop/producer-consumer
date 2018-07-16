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
			for(int i=0;i<100;i++)	
				employee = consumerControllerClient.getEmployee();
		} catch (RestClientException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee getEmployee2() {
		Employee employee = new Employee();
		try {
			employee = consumerControllerClient.getEmployeeFeign();
		} catch (RestClientException | IOException e) {			
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee getEmployeeZull() {
		Employee employee = new Employee();
		try {
			employee = consumerControllerClient.getEmployeeZull();
		} catch (RestClientException | IOException e) {			
			e.printStackTrace();
		}
		return employee;
	}

}
