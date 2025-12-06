package com.example.storeapp_consumer_eureka_feign.proxy;

import com.example.storeapp_consumer_eureka_feign.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductServiceProxy {

    @GetMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, headers = {})
    public Product getProductById(@PathVariable("id") Long id);

    @GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Product> getAllProducts();

}
