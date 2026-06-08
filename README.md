# 💼 Personal Finance Manager

[![Backend](https://img.shields.io/badge/Backend-Spring%20Boot%20%7C%20Java-red.svg)]()
[![Database](https://img.shields.io/badge/Database-MySQL-blue.svg)]()
[![Frontend](https://img.shields.io/badge/Frontend-HTML5%20%7C%20CSS3%20%7C%20JavaScript-orange.svg)]()

A robust, full-stack financial portfolio management system designed to empower users with secure transaction ledger tracking, automated income/expense analysis, and zero-latency real-time account balance updates. This application delivers a clean administrative dashboard backed by an enterprise-grade REST API architecture.

---

## 🎯 Core Engineering & System Highlights

* **Enterprise Java Backend:** Built leveraging **Spring Boot** with a strictly decoupled layered architecture (Controllers, Services, Repositories), ensuring high testability, maintenance scalability, and clean separation of concerns.
* **Relational Data Integrity:** Implements a robust **MySQL relational database layer** using **Spring Data JPA / Hibernate** for Object-Relational Mapping (ORM), guaranteeing transactional safety (ACID compliance) during financial ledger mutations.
* **Real-Time Analytical Calculations:** Features optimized runtime computational logic to handle multi-category balance recalculations, calculating complex running totals without blocking thread execution loops.
* **Unified REST API Design:** Exposes clean, structured RESTful API endpoints for seamless financial object CRUD operations, structured with clear JSON validation payloads.
* **Lightweight Responsive UI:** Built utilizing semantic HTML5, CSS3 transitions, and native asynchronous JavaScript (`Fetch API`) to manage data exchanges dynamically without frustrating full-page refreshes.

---

## 🗺️ System Architecture

```text
       ┌─────────────────────────────────────────────────────────┐
       │                    FRONTEND CLIENT                      │
       │          (HTML5 / CSS3 / Vanilla JavaScript)           │
       └────────────────────────────┬────────────────────────────┘
                                    │
                        Async HTTP Fetch (JSON)
                                    ▼
       ┌─────────────────────────────────────────────────────────┐
       │                 SPRING BOOT API SERVER                  │
       │       (Controller ──► Service ──► Repository)           │
       └────────────────────────────┬────────────────────────────┘
                                    │
                           Spring Data JPA
                                    ▼
       ┌─────────────────────────────────────────────────────────┐
       │                 DATABASE PERSISTENCE                    │
       │                    (MySQL RDBMS)                        │
       └─────────────────────────────────────────────────────────┘


🔄 Architectural Data Workflow
Presentation Layer: The user interacts with the native HTML5/CSS3 dashboard interface. Client-side state transitions trigger asynchronous browser Fetch API networking operations without forcing complete page reloads.

Business Logic Layer: The incoming JSON network requests hit the REST Controllers exposed by the Spring Boot application engine. Requests are validated and parsed through decoupled Service components containing the application's transaction logic.

Data Access Layer: The verified application state updates are translated by Spring Data JPA & Hibernate into corresponding transactional Structured Query Language commands.

Relational Storage Layer: The physical data mutations are recorded inside a relational MySQL database cluster ensuring rigid ACID transactional compliance and long-term state integrity.

🧱 Technical Core Specifications
⚙️ Backend Engineering
Language/Runtime: Java (JDK 17+)

Framework: Spring Boot (Web, DevTools)

Data Persistence: Spring Data JPA, Hibernate Core

Build Automation: Maven / Gradle

🗄️ Database Layer
RDBMS Engine: MySQL

Driver: MySQL Connector/J

🎨 Frontend Layer
Markup & Styling: HTML5 / Modern CSS Grid & Flexbox

Scripting Engine: Vanilla JavaScript (Asynchronous DOM state updating)
