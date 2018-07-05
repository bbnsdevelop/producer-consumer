package br.com.producerconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.producerconsumer.client.ConsumerControllerClient;

@SpringBootApplication
public class ProducerconsumerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ProducerconsumerApplication.class, args);
		
		ConsumerControllerClient consumerClient = ctx.getBean(ConsumerControllerClient.class);
		System.out.println(consumerClient);
		consumerClient.getProducerEmployee();
	}
	
	@Bean
	public ConsumerControllerClient consumerControllerClient() {
		return new ConsumerControllerClient();
	}
}
