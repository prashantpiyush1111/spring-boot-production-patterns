package com.example.bulkhead;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class OrderService {

    @Async("orderServiceExecutor")
    public CompletableFuture<String> processOrder(String orderId) {
        try {
            // Simulate slow order processing
            Thread.sleep(2000);
            return CompletableFuture.completedFuture(
                "Order processed successfully! OrderId: " + orderId
            );
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return CompletableFuture.completedFuture(
                "Order processing failed for OrderId: " + orderId
            );
        }
    }
}