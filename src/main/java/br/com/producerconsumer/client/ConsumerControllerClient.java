package br.com.producerconsumer.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.producerconsumer.client.domain.Employee;

public class ConsumerControllerClient {

	private static final Logger log = LoggerFactory.getLogger(ConsumerControllerClient.class);

	public Employee getProducerEmployee() {

		String baseUrl = "http://localhost:8080/api/employee";
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
