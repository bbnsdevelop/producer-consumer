package br.com.producerconsumer.service.feiggnClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.producerconsumer.client.domain.Employee;

@FeignClient(name="producer")
public interface ConsumerRemoteCallProduceService {

	@RequestMapping(method=RequestMethod.GET, value="/api/employee")
	public Employee getData();
}
