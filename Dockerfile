# ── Build stage ──────────────────────────────────────────────
FROM eclipse-temurin:17 AS build
WORKDIR /app

COPY gradle/       gradle/
COPY gradlew       build.gradle   settings.gradle   ./
RUN  chmod +x gradlew
COPY src/          src/
RUN  ./gradlew jar --no-daemon

# ── Runtime stage ─────────────────────────────────────────────
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/build/libs/ads-cli-app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
