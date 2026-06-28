\# Idempotency Pattern



\## Problem

Users sometimes click "Submit" twice, or networks retry failed requests. 

This causes duplicate payments, duplicate orders — real money lost.



\## Solution

Assign every request a unique `Idempotency-Key`. If the same key arrives again, 

return the cached response instead of processing again.



\## How it Works

1\. Client sends request with `Idempotency-Key: <unique-id>` header

2\. Server checks if this key was already processed

3\. If yes → return cached response (no duplicate processing)

4\. If no → process request, save response against the key



\## Tech Stack

\- Java 17

\- Spring Boot 3.5.x

\- Spring Boot Actuator



\## How to Run

```bash

cd 04-idempotency

./mvnw spring-boot:run

```



\## Test API

```bash

\# First request - processes payment

curl -X POST http://localhost:8080/api/payments \\

&#x20; -H "Content-Type: application/json" \\

&#x20; -H "Idempotency-Key: order-abc-123" \\

&#x20; -d '{"orderId":"ORD001","amount":999.99}'



\# Same request again - returns cached response, no duplicate

curl -X POST http://localhost:8080/api/payments \\

&#x20; -H "Content-Type: application/json" \\

&#x20; -H "Idempotency-Key: order-abc-123" \\

&#x20; -d '{"orderId":"ORD001","amount":999.99}'

```



\## When to Use

\- Payment APIs

\- Order placement

\- Any operation that must not run twice



\## When NOT to Use

\- Read operations (GET requests are already idempotent)

\- Operations where duplicates are acceptable

