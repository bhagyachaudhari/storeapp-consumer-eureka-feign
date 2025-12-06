package com.example.storeapp_consumer_eureka_feign.controller;

import com.example.storeapp_consumer_eureka_feign.model.Product;
import com.example.storeapp_consumer_eureka_feign.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("request")
public class ProductClientController {

    @Autowired
    private ProductServiceProxy productServiceProxy;
    @GetMapping("/get-products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productServiceProxy.getProductById(id);
    }

    @GetMapping("/get-all-products")
    public List<Product> getAllProducts() {
        return productServiceProxy.getAllProducts();
    }

}
