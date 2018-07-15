package br.com.producerconsumer.client;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.producerconsumer.client.domain.Employee;

@Controller
public class ConsumerControllerClient {

	private static final Logger log = LoggerFactory.getLogger(ConsumerControllerClient.class);
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	public Employee getEmployee() throws RestClientException, IOException {
		
		List<ServiceInstance> instances = discoveryClient.getInstances("producer");
		ServiceInstance serviceInstance = instances.get(0);
		
		String baseUrl = serviceInstance.getUri().toString();
		baseUrl = baseUrl + "/api/employee";
		log.info("url {}", baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
			log.info("response {}", response.getBody());
		} catch (Exception ex) {
			log.error("erro ao comunicar com o servico {}, causa {}", baseUrl, ex.getMessage());
		}
		Gson gson = new Gson();
		Employee employee = gson.fromJson(response.getBody(), Employee.class);

		return employee;
	}

	private HttpEntity<?> getHeaders() {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
