\# Bulkhead Pattern



\## Problem

All services share the same thread pool. If one service gets slow or overloaded,

it consumes all threads — bringing down every other service too.



\## Solution

Isolate each service into its own thread pool (bulkhead).

If one service fails or slows down, others continue working normally.



\## How it Works

1\. OrderService gets its own thread pool (2 threads)

2\. PaymentService gets its own thread pool (2 threads)

3\. If OrderService is slow/overloaded — PaymentService is unaffected

4\. Each service can only use its own allocated threads



\## Tech Stack

\- Java 17

\- Spring Boot 3.5.x

\- Spring Async (@Async)

\- ThreadPoolTaskExecutor

\- Spring Boot Actuator



\## How to Run

```bash

cd 06-bulkhead

./mvnw spring-boot:run

```



\## Test API

```bash

\# Test Order Service (slow - 2 seconds)

curl http://localhost:8080/api/order/ORD001



\# Test Payment Service (fast - 0.5 seconds)

curl http://localhost:8080/api/payment/PAY001

```



\## When to Use

\- Microservices with multiple downstream dependencies

\- When one slow service should not affect others

\- High traffic systems where resource isolation is critical



\## When NOT to Use

\- Simple single-service applications

\- When all operations have similar priority and speed

