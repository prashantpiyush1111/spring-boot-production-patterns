\# Dead Letter Queue (DLQ) Pattern



\## Problem

Messages/requests sometimes fail during processing. If we keep retrying forever,

it blocks the queue. If we drop them, we lose important data.



\## Solution

After a maximum number of retries, move failed messages to a separate 

Dead Letter Queue (DLQ). Main queue stays healthy, failed messages are 

preserved for investigation and manual retry.



\## How it Works

1\. Message enters main queue

2\. Processing attempted — if fails → retry count incremented

3\. After MAX\_RETRIES (3) → message moved to DLQ

4\. Main queue continues processing other messages

5\. DLQ can be inspected and replayed later



\## Tech Stack

\- Java 17

\- Spring Boot 3.5.x

\- ConcurrentLinkedQueue (in-memory)

\- Spring Boot Actuator



\## How to Run

```bash

cd 10-dead-letter-queue

./mvnw spring-boot:run

```



\## Test API

```bash

\# Send a message

curl -X POST "http://localhost:8080/api/queue/send?id=MSG001\&content=HelloWorld"



\# Process message (run multiple times to trigger retries)

curl http://localhost:8080/api/queue/process



\# Check queue status

curl http://localhost:8080/api/queue/status



\# View DLQ contents

curl http://localhost:8080/api/queue/dlq

```



\## When to Use

\- Payment processing failures

\- Email/notification delivery failures

\- Any async operation that must not be lost on failure



\## When NOT to Use

\- Synchronous APIs (use Circuit Breaker or Retry instead)

\- Operations where failure is expected and acceptable

