\# Health Check Pattern



\## Problem

Load balancers, Kubernetes, and monitoring tools need to know if a service 

is alive and ready to handle traffic. Without health checks, a dead or 

degraded service keeps receiving requests — causing failures for users.



\## Solution

Expose a health endpoint that reports the service's status and the status 

of its dependencies (database, downstream services, disk space, etc.).



\## How it Works

1\. Spring Boot Actuator exposes `/actuator/health` automatically

2\. Custom `HealthIndicator` checks downstream dependencies

3\. If everything is healthy → status `UP`

4\. If a dependency fails → status `DOWN`, request routing can be stopped



\## Tech Stack

\- Java 17

\- Spring Boot 3.5.x

\- Spring Boot Actuator



\## How to Run

```bash

cd 07-health-check

./mvnw spring-boot:run

```



\## Test API

```bash

curl http://localhost:8080/actuator/health

```



\## When to Use

\- Kubernetes liveness/readiness probes

\- Load balancer health checks

\- Monitoring dashboards (Grafana, Datadog, etc.)



\## When NOT to Use

\- Internal-only services with no orchestration/monitoring setup

