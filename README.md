# ADS Dental Appointment Management System

A Command-Line Interface (CLI) application for Adventist Dental Surgeries (ADS), LLC to manage dental appointments across their network of surgery locations.

---

## Runtime Requirements

| Tool | Version |
|------|---------|
| **Java** | Java 17 or higher (tested on Java 25) |
| **Gradle** (optional) | 9.2.0 (wrapper included — no install needed) |

---

## Project Structure

```
src/main/java/miu/lesson/midexam/
├── ADSAppMain.java          ← Application entry point
├── domain/                  ← Domain model (Patient, Dentist, Surgery, Appointment, Bill, …)
├── db/                      ← Data access layer (DBContext — singleton in-memory store)
├── service/                 ← Business logic (AppointmentService)
├── ui/                      ← Presentation layer (ConsoleUI)
└── util/                    ← Utilities (JSONUtil)
```

---

## Build the Executable JAR

```bash
./gradlew jar
```

The fat/uber JAR (with all dependencies bundled) is produced at:

```
build/libs/ads-cli-app.jar
```

---

## Run the Application

```bash
java -jar build/libs/ads-cli-app.jar
```

The application prints two sections to the console:

1. **All Appointments** – every appointment in the system, sorted by date/time **descending**, in JSON format with full patient, dentist, and surgery details.
2. **Quarterly Upcoming Appointments** – appointments whose date falls in the **next calendar quarter** relative to today, sorted by date/time **ascending**, in JSON format with full patient details.

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

---

## Build Tool

**Gradle 9.2.0** (via the included Gradle Wrapper — `./gradlew`).  
No local Gradle installation is required.

---

## JSON Library

[org.json 20231013](https://github.com/stleary/JSON-java) — used via `JSONObject` and `JSONArray` APIs (no manual string serialization).
