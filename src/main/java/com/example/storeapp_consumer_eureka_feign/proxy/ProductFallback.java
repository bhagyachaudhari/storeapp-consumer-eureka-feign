package com.example.storeapp_consumer_eureka_feign.proxy;

import com.example.storeapp_consumer_eureka_feign.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFallback implements ProductServiceProxy {

    @Override
    public Product getProductById(Long id) {
        System.out.println("Fallback: Product service not available");
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        System.out.println("Fallback: Product service not available");
        return null;
    }
}

