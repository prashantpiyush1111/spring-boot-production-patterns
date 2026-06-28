package com.example.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<String> getProduct(@PathVariable String productId) {
        long startTime = System.currentTimeMillis();
        
        String product = productService.getProductById(productId);
        
        long timeTaken = System.currentTimeMillis() - startTime;
        
        return ResponseEntity.ok(product + " | Time taken: " + timeTaken + "ms");
    }
}