package br.com.producerconsumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.producerconsumer.client.ConsumerControllerClient;
import br.com.producerconsumer.client.domain.Employee;
import br.com.producerconsumer.service.ConsumerClientService;

@Service
public class ConsumerClientServiceImpl implements ConsumerClientService{

	@Autowired
	private ConsumerControllerClient consumerControllerClient;
	
	@Override
	public Employee getEmployee() {
		return consumerControllerClient.getProducerEmployee();
	}

}
