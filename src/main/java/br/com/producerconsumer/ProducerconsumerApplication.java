package br.com.producerconsumer;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import br.com.producerconsumer.client.ConsumerControllerClient;

@SpringBootApplication
@EnableFeignClients
public class ProducerconsumerApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		SpringApplication.run(ProducerconsumerApplication.class, args);

	}

	@Bean
	public ConsumerControllerClient consumerControllerClient() {
		return new ConsumerControllerClient();
	}
}
