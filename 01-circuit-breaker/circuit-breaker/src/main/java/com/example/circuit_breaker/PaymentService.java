package com.example.circuit_breaker;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final String CIRCUIT_BREAKER_NAME = "paymentService";

    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "paymentFallback")
    public String processPayment(String orderId) {
        if (Math.random() > 0.5) {
            throw new RuntimeException("Payment service is down!");
        }
        return "Payment successful for order: " + orderId;
    }

    public String paymentFallback(String orderId, Throwable t) {
        return "Payment service unavailable. Please try again later. Order: " + orderId;
    }
}