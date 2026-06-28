package com.example.idempotency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private IdempotencyStore idempotencyStore;

    @PostMapping
    public ResponseEntity<String> processPayment(
            @RequestHeader("Idempotency-Key") String idempotencyKey,
            @RequestBody PaymentRequest request) {

        // Duplicate request check
        if (idempotencyStore.contains(idempotencyKey)) {
            String cachedResponse = idempotencyStore.get(idempotencyKey);
            return ResponseEntity.ok("[DUPLICATE DETECTED - Returning cached response]: " + cachedResponse);
        }

        // Process payment (simulate)
        String response = "Payment successful! Order: " + request.getOrderId() 
                        + " | Amount: ₹" + request.getAmount();

        // Save response against idempotency key
        idempotencyStore.save(idempotencyKey, response);

        return ResponseEntity.ok(response);
    }
}