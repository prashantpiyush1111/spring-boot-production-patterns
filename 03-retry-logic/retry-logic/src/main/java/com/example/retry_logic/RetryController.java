package com.example.retry_logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/retry")
public class RetryController {

    @Autowired
    private ExternalService externalService;

    @GetMapping("/call")
    public ResponseEntity<String> callService() {
        try {
            String result = externalService.callUnstableService();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.ok(externalService.fallback());
        }
    }
}