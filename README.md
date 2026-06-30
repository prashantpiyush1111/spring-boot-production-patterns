# 🚀 Spring Boot Production Patterns

> Real-world Spring Boot patterns with working code & Docker setup.
> Inspired by [java-design-patterns](https://github.com/iluwatar/java-design-patterns) — but for production problems.

![Java](https://img.shields.io/badge/Java-17+-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.x-brightgreen?style=flat-square&logo=springboot)
![Patterns](https://img.shields.io/badge/Patterns-7-blue?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)
![Contributions Welcome](https://img.shields.io/badge/Contributions-Welcome-brightgreen?style=flat-square)
[![CI - Build All Patterns](https://github.com/prashantpiyush1111/spring-boot-production-patterns/actions/workflows/ci.yml/badge.svg)](https://github.com/prashantpiyush1111/spring-boot-production-patterns/actions/workflows/ci.yml)

---

## 🎯 What is this?

Most tutorials show you how to build a Spring Boot app.
**This repo shows you what to do when it breaks in production.**

Every pattern includes:
- ✅ Working Spring Boot code
- ✅ Docker Compose setup
- ✅ When to use & when NOT to use

---

## 📦 Patterns

| # | Pattern | Description | Status |
|---|---------|-------------|--------|
| 01 | [Circuit Breaker](./01-circuit-breaker) | Stop cascading failures when a service goes down | ✅ Done |
| 02 | [Rate Limiting](./02-rate-limiting) | Control how many requests a client can make | ✅ Done |
| 03 | [Retry Logic](./03-retry-logic) | Automatically retry failed operations with backoff | ✅ Done |
| 04 | [Idempotency](./04-idempotency) | Prevent duplicate processing of the same request | ✅ Done |
| 05 | [Caching](./05-caching) | Reduce DB load by serving repeated requests from cache | ✅ Done |
| 06 | [Bulkhead](./06-bulkhead) | Isolate failures using separate thread pools per service | ✅ Done |
| 07 | [Health Check](./07-health-check) | Monitor service health via actuator endpoints | ✅ Done |
| 08 | Saga Pattern | Manage distributed transactions across microservices | ⏳ Coming Soon |

---

## 🚀 Getting Started

Each pattern is standalone. Just go to any folder and run:

```bash
cd <pattern-folder>/<project-folder>
./mvnw spring-boot:run
```

Or with Docker:

```bash
cd <pattern-folder>
docker-compose up
```

---

## 🤝 Contributing

Contributions are welcome! Please read [CONTRIBUTING.md](./CONTRIBUTING.md) first.

---

## 👨‍💻 Author

**Prashant Maurya**
- GitHub: [@prashantpiyush1111](https://github.com/prashantpiyush1111)
- LinkedIn: [prashantpiyush1111](https://linkedin.com/in/prashantpiyush1111)

---

## 📄 License

MIT License — free to use, modify, and distribute.