package com.example.storeapp_consumer_eureka_feign.config;

import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomFeignDecoderConfig {

    @Bean
    public Decoder feignDecoder() {
        return (response, type) -> {
            System.out.println("Received Feign Response: " + response.status());
            /*return new Gson().fromJson(
                    Util.toString(response.body().asReader()),
                    type
            );*/
            return null;
        };
    }
}

