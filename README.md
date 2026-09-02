# 🚀 Spring Boot Production Patterns

> A practical collection of Spring Boot patterns for building more resilient, reliable, and production-oriented services.

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.x-brightgreen?style=flat-square&logo=springboot)
![Patterns](https://img.shields.io/badge/Patterns-10-blue?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)

## 🎯 Why This Repository?

Many tutorials focus on getting a Spring Boot application running. This repository focuses on the problems that appear when a service must handle failures, retries, load, duplicate requests, caching, shutdowns, and asynchronous processing.

Each pattern is implemented as a focused example with an emphasis on **when to use it, what problem it solves, and what trade-offs it introduces**.

## 📦 Patterns

| # | Pattern | Problem Addressed |
|---|---|---|
| 01 | Circuit Breaker | Prevent cascading failures when a dependency is unavailable |
| 02 | Rate Limiting | Control request volume from clients |
| 03 | Retry Logic | Recover from transient failures with retry/backoff |
| 04 | Idempotency | Prevent duplicate processing of the same request |
| 05 | Caching | Reduce repeated database or service calls |
| 06 | Bulkhead | Isolate failures and resource usage between operations |
| 07 | Health Check | Expose service health for operational monitoring |
| 08 | Throttling | Control concurrent work with a semaphore-based approach |
| 09 | Graceful Shutdown | Allow in-flight work to complete during shutdown |
| 10 | Dead Letter Queue | Preserve failed messages for retry and investigation |

## 🧱 Pattern Structure

Each example is kept focused so it can be studied independently.

```text
Pattern
├── Example implementation
├── Configuration
├── Supporting classes
└── Usage / notes
```

## 🛠️ Technology Stack

- Java 17+
- Spring Boot 3.5.x
- Maven
- Docker / Docker Compose
- Spring Boot Actuator where applicable

## 🚀 Getting Started

Each pattern is designed to be explored independently.

### Run with Maven

From the relevant project directory:

```bash
./mvnw spring-boot:run
```

### Run with Docker

From a pattern directory that provides Compose configuration:

```bash
docker-compose up
```

## 🧠 How to Study the Repository

A useful learning order is:

```text
Failure Recovery
   ↓
Traffic Control
   ↓
Duplicate Request Protection
   ↓
Resource Isolation
   ↓
Operational Resilience
   ↓
Asynchronous Failure Handling
```

The key goal is understanding the **trade-off behind each pattern**, not using patterns everywhere by default.

## 🤝 Contributing

Contributions are welcome. Please read [CONTRIBUTING.md](./CONTRIBUTING.md) before opening a pull request.

## 👨‍💻 Author

**Prashant Maurya**  
GitHub: [@prashantpiyush1111](https://github.com/prashantpiyush1111)  
LinkedIn: [Prashant Maurya](https://linkedin.com/in/prashantpiyush1111)

## 📄 License

MIT License
