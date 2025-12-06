package com.example.storeapp_consumer_eureka_feign.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class FeignInterceptorConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            // Add Auth Header
            requestTemplate.header("Authorization", "Bearer abc123");

            // Add Trace ID
            String traceId = UUID.randomUUID().toString();
            requestTemplate.header("X-Trace-ID", traceId);

            // Log the outgoing request
            System.out.println("Feign Request → " + requestTemplate.url() +
                    " | TraceID: " + traceId);
        };
    }
}
