package com.example.storeapp_consumer_eureka_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StoreappConsumerEurekaFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreappConsumerEurekaFeignApplication.class, args);
	}

}
