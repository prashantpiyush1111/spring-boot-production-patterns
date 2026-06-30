package com.example.health_check;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean isServiceHealthy = checkDownstreamService();

        if (isServiceHealthy) {
            return Health.up()
                    .withDetail("downstream-service", "Available")
                    .withDetail("status", "All systems operational")
                    .build();
        }

        return Health.down()
                .withDetail("downstream-service", "Unavailable")
                .withDetail("status", "Service degraded")
                .build();
    }

    private boolean checkDownstreamService() {
        // Simulate checking a downstream dependency (DB, external API, etc.)
        return true; // change to false to simulate failure
    }
}