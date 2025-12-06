package com.example.storeapp_consumer_eureka_feign.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignRetryConfig {

    @Bean
    public Retryer retryer() {
        // Retry 3 times, with initial delay 100ms, max delay 1 second
        return new Retryer.Default(100, System.currentTimeMillis(), 3);
    }
}
