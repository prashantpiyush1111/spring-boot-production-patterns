\# Circuit Breaker Pattern



\## Problem

When a service fails repeatedly, it causes cascading failures across the entire system.



\## Solution

Circuit Breaker pattern detects service failures and automatically returns a fallback response instead of crashing.



\## How it Works



CLOSED - failures are low - normal operation

OPEN - failures are high - fallback is returned

HALF-OPEN - few requests allowed - checks if service recovered



\## Tech Stack

\- Java 17

\- Spring Boot 3.5.14

\- Resilience4j

\- Spring Boot Actuator



\## How to Run



cd circuit-breaker

./mvnw spring-boot:run



\## Test API



GET http://localhost:8080/api/payment/process/{orderId}



\## Monitor Circuit Breaker



GET http://localhost:8080/actuator/health



\## When to Use

\- External API calls

\- Database connections

\- Microservices communication

