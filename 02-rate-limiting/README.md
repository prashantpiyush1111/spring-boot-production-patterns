\# Rate Limiting Pattern



\## Problem

Without limits, a single user or bot can flood your API with requests, overloading the server and degrading performance for everyone else.



\## Solution

Rate Limiting controls how many requests a client can make in a given time window. Excess requests are rejected with a 429 status instead of overwhelming the system.



\## How it Works



Each client gets a "bucket" with a fixed number of tokens.

Every request consumes 1 token.

Bucket refills at a fixed rate (e.g. 5 tokens per minute).

No tokens left = request rejected (429 Too Many Requests).



\## Tech Stack

\- Java 17

\- Spring Boot 3.5.15

\- Bucket4j

\- Spring Boot Actuator



\## How to Run



cd rate-limiting

./mvnw spring-boot:run



\## Test API



GET http://localhost:8080/api/data



Refresh 6+ times quickly to see the rate limit trigger.



\## When to Use

\- Public APIs

\- Login/auth endpoints (prevent brute force)

\- Protecting downstream services from traffic spikes

