package com.example.circuit_breaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/process/{orderId}")
    public ResponseEntity<String> processPayment(@PathVariable String orderId) {
        try {
            String result = paymentService.processPayment(orderId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.ok("Payment service unavailable. Please try again later. Order: " + orderId);
        }
    }
}