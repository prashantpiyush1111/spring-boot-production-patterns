package com.example.throttling;

import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

@Service
public class ThrottlingService {

    // Max 3 concurrent requests allowed per user
    private final ConcurrentHashMap<String, Semaphore> userSemaphores 
        = new ConcurrentHashMap<>();

    public String processRequest(String userId) throws InterruptedException {
        Semaphore semaphore = userSemaphores.computeIfAbsent(
            userId, k -> new Semaphore(3)
        );

        if (!semaphore.tryAcquire()) {
            return "THROTTLED: Too many concurrent requests. Please wait.";
        }

        try {
            // Simulate processing time
            Thread.sleep(2000);
            return "Request processed successfully for user: " + userId;
        } finally {
            semaphore.release();
        }
    }
}