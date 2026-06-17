package com.example.retry_logic;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class ExternalService {

    private int attemptCount = 0;

    @Retryable(
        value = RuntimeException.class,
        maxAttempts = 3,
        backoff = @Backoff(delay = 1000)
    )
    public String callUnstableService() {
        attemptCount++;
        System.out.println("Attempt #" + attemptCount);

        if (Math.random() > 0.4) {
            throw new RuntimeException("Service temporarily unavailable!");
        }

        attemptCount = 0;
        return "Service call successful!";
    }

    public String fallback() {
        attemptCount = 0;
        return "Service unavailable after multiple retries. Please try again later.";
    }
}