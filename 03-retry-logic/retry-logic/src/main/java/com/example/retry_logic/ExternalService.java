package com.example.retry_logic;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class ExternalService {

    @Retryable(
        value = RuntimeException.class,
        maxAttempts = 3,
        backoff = @Backoff(delay = 1000)
    )
    public String callUnstableService() {
        int attemptCount = 0;

        attemptCount++;
        System.out.println("Attempt #" + attemptCount);

        if (Math.random() > 0.4) {
            throw new RuntimeException("Service temporarily unavailable!");
        }

        return "Service call successful!";
    }

    public String fallback() {
        return "Service unavailable after multiple retries. Please try again later.";
    }
}
