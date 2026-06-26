package com.example.caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Cacheable("products")
    public String getProductById(String productId) {
        // Simulate slow DB call
        simulateSlowDB();
        return "Product details for ID: " + productId + " | Price: ₹" + (Integer.parseInt(productId) * 100);
    }

    private void simulateSlowDB() {
        try {
            Thread.sleep(3000); // 3 second delay simulate kar raha hai DB call
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}