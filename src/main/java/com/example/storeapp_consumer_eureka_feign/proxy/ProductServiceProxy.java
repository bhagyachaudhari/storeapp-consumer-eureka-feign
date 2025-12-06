package com.example.storeapp_consumer_eureka_feign.proxy;

import com.example.storeapp_consumer_eureka_feign.config.CustomFeignDecoderConfig;
import com.example.storeapp_consumer_eureka_feign.config.FeignInterceptorConfig;
import com.example.storeapp_consumer_eureka_feign.config.FeignRetryConfig;
import com.example.storeapp_consumer_eureka_feign.config.FeignTimingConfig;
import com.example.storeapp_consumer_eureka_feign.model.Product;
import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Retryable(
        value = {FeignException.class},
        maxAttempts = 4,
        backoff = @Backoff(delay = 200)
)
@FeignClient(
        name = "product-service",
        configuration = {FeignRetryConfig.class, FeignInterceptorConfig.class, CustomFeignDecoderConfig.class, FeignTimingConfig.class},
        fallback = ProductFallback.class
)
public interface ProductServiceProxy {

    @GetMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, headers = {})
    public Product getProductById(@PathVariable("id") Long id);

    @GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Product> getAllProducts();

}
