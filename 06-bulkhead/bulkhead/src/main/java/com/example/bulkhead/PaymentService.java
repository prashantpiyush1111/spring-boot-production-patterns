package com.example.bulkhead;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class PaymentService {

    @Async("paymentServiceExecutor")
    public CompletableFuture<String> processPayment(String paymentId) {
        try {
            // Simulate fast payment processing
            Thread.sleep(500);
            return CompletableFuture.completedFuture(
                "Payment processed successfully! PaymentId: " + paymentId
            );
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return CompletableFuture.completedFuture(
                "Payment processing failed for PaymentId: " + paymentId
            );
        }
    }
}