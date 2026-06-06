# ADS Dental Appointment Management System

A Command-Line Interface (CLI) application for **Adventist Dental Surgeries (ADS), LLC** to manage dental appointments across their network of surgery locations.

---

## Runtime Requirements

| Tool | Version |
|------|---------|
| **Java** | Java 17 or higher (tested on Java 25) |
| **Gradle** | 9.2.0 — wrapper included, no local install needed |

---

## Project Structure

```
src/main/java/miu/lesson/midexam/
│
├── ADSAppMain.java                     ← Application entry point
│
├── model/                              ← Domain model layer
│   ├── Appointment.java
│   ├── AppointmentStatus.java          (enum: PENDING, CONFIRMED, CANCELLED, COMPLETED)
│   ├── Bill.java
│   ├── Notification.java
│   ├── Surgery.java
│   ├── auth/
│   │   ├── Role.java                   (enum: PATIENT, DENTIST, OFFICE_CLERK, DIRECTOR)
│   │   └── User.java
│   └── person/
│       ├── Person.java                 (abstract base class)
│       ├── Patient.java
│       ├── Dentist.java
│       ├── OfficeClerk.java
│       └── Director.java
│
├── db/
│   └── DBContext.java                  ← In-memory data store (Singleton)
│
├── repository/                         ← Data access layer (Singleton repositories)
│   ├── AppointmentRepository.java
│   ├── PatientRepository.java
│   ├── DentistRepository.java
│   ├── SurgeryRepository.java
│   └── BillRepository.java
│
├── service/                            ← Business logic layer
│   ├── AppointmentService.java         (interface)
│   ├── ReportService.java              (interface)
│   └── impl/
│       ├── AppointmentServiceImpl.java
│       └── ReportServiceImpl.java
│
└── util/
    └── JSONUtil.java                   ← JSON serialization helper (org.json)
```

---

## Build the Executable JAR

```bash
./gradlew jar
```

Produces a self-contained fat JAR at:

```
build/libs/ads-cli-app.jar
```

---

## Run the Application

```bash
java -jar build/libs/ads-cli-app.jar
```

The application prints two sections to the console:

### 4.2.1 — All Appointments (sorted by Date/Time DESC)
Every appointment in the system in JSON format, sorted newest-first, including full patient (with age), dentist, and surgery details.

### 4.2.2 — Quarterly Upcoming Appointments (sorted by Date/Time ASC)
Appointments whose date falls within the **next calendar quarter** relative to today, sorted earliest-first in JSON format.

> **Quarter logic example:** if today is 2026-Jun-06 (Q2), the next quarter is Q3 2026 (Jul 01 – Sep 30).

---

## GitHub Repository

```
https://github.com/dturbat/ads-cli-app
```

---

## Docker

The container image is published at:

```
https://hub.docker.com/r/dturbat/ads-cli-app
```

### Pull and run from Docker Hub

```bash
docker pull dturbat/ads-cli-app:latest
docker run --rm dturbat/ads-cli-app:latest
```

### Build image locally

```bash
docker build -t dturbat/ads-cli-app:latest .
docker run --rm dturbat/ads-cli-app:latest
```

---

## Technology Stack

| Component | Details |
|-----------|---------|
| Language | Java 17+ |
| Build tool | Gradle 9.2.0 (Wrapper) |
| JSON library | org.json 20231013 |
| Containerisation | Docker (eclipse-temurin:17-jre) |
| Architecture | Layered — model / db / repository / service / util |
