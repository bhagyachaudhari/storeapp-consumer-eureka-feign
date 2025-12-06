package com.example.storeapp_consumer_eureka_feign.config;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignTimingConfig {

    @Bean
    public RequestInterceptor timingInterceptor() {
        return template -> {
            long start = System.currentTimeMillis();
            template.header("X-Start-Time", String.valueOf(start));
        };
    }

    @Bean
    public Decoder timingDecoder() {
        return (response, type) -> {
            long start = Long.parseLong(response.request().headers().get("X-Start-Time").iterator().next());
            long duration = System.currentTimeMillis() - start;

            System.out.println("Feign Call Duration = " + duration + "ms");

            /*return new SpringDecoder(() -> new ObjectMapper())
                    .decode(response, type);*/
            return null;
        };
    }
}

