package com.example.rate_limiting;

import io.github.bucket4j.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private Bucket rateLimitBucket;

    @GetMapping("/data")
    public ResponseEntity<String> getData() {
        if (rateLimitBucket.tryConsume(1)) {
            return ResponseEntity.ok("Request successful! Data fetched.");
        } else {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body("Rate limit exceeded. Please try again later.");
        }
    }
}