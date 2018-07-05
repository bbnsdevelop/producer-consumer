package br.com.producerconsumer.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ConsumerControllerClient {
	
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public void getProducerEmployee() {
		
		List<ServiceInstance> instances = discoveryClient.getInstances("producer-consumer");
		ServiceInstance serviceInstance=instances.get(0);
		
		String baseUrl=serviceInstance.getUri().toString();
		
		baseUrl=baseUrl+"/employee";
		
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response=null;

		
		try {
			response = rest.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(response.getBody());
	}

	private HttpEntity<?> getHeaders() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
