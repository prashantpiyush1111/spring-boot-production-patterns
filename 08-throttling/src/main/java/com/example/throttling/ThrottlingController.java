package com.example.throttling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ThrottlingController {

    @Autowired
    private ThrottlingService throttlingService;

    @GetMapping("/process")
    public ResponseEntity<String> processRequest(
            @RequestParam(defaultValue = "user1") String userId) {
        try {
            String result = throttlingService.processRequest(userId);
            return ResponseEntity.ok(result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return ResponseEntity.ok("Request interrupted");
        }
    }
}