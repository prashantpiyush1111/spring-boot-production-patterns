package com.example.bulkhead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class BulkheadController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/order/{orderId}")
    public ResponseEntity<String> processOrder(@PathVariable String orderId) {
        try {
            CompletableFuture<String> result = orderService.processOrder(orderId);
            return ResponseEntity.ok(result.get());
        } catch (Exception e) {
            return ResponseEntity.ok("Order service busy! Please try again.");
        }
    }

    @GetMapping("/payment/{paymentId}")
    public ResponseEntity<String> processPayment(@PathVariable String paymentId) {
        try {
            CompletableFuture<String> result = paymentService.processPayment(paymentId);
            return ResponseEntity.ok(result.get());
        } catch (Exception e) {
            return ResponseEntity.ok("Payment service busy! Please try again.");
        }
    }
}