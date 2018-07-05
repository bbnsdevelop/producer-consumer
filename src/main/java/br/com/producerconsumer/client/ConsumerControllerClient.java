package br.com.producerconsumer.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ConsumerControllerClient {

	public void getProducerEmployee() {
		
		String baseUrl = "http://localhost:8080/api/employee";
		
		RestTemplate rest = new RestTemplate();
		
		ResponseEntity<String> response = null;
		
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
