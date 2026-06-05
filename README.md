# 🚀 Spring Boot Production Patterns

> Real-world Spring Boot patterns with working code, architecture diagrams & Docker setup.
> Inspired by [java-design-patterns](https://github.com/iluwatar/java-design-patterns) — but for production problems.

![Java](https://img.shields.io/badge/Java-17+-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![License](https://img.shields.io/badge/License-MIT-blue)
![Contributions Welcome](https://img.shields.io/badge/Contributions-Welcome-brightgreen)

## 🎯 What is this?

Most tutorials show you how to build a Spring Boot app.
**This repo shows you what to do when it breaks in production.**

Every pattern includes:
- ✅ Working Spring Boot code
- ✅ Architecture diagram
- ✅ Docker Compose setup
- ✅ When to use & when NOT to use

## 📦 Patterns

| # | Pattern | Description |
|---|---------|-------------|
| 01 | [Circuit Breaker](./01-circuit-breaker) | Stop cascading failures |
| 02 | [Rate Limiting](./02-rate-limiting) | Control incoming traffic |
| 03 | [Retry Logic](./03-retry-logic) | Handle transient failures |

## 🚀 Getting Started

Each pattern is standalone. Just go to any folder and run:

```bash
docker-compose up
```

## 🤝 Contributing

Contributions are welcome! Please read [CONTRIBUTING.md](./CONTRIBUTING.md) first.

## 📄 License

MIT License — free to use, modify, and distribute.