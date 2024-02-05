FROM maven:3-eclipse-temurin-21 AS builder
LABEL authors="chrisvandalen"
WORKDIR /app

COPY . .

RUN mvn clean install

FROM openjdk:21-slim

WORKDIR /app

COPY --from=builder /app/app/target/app-0.0.1-SNAPSHOT.jar app.jar
COPY --from=builder /app/api/target/api-0.0.1-SNAPSHOT.jar api.jar
COPY --from=builder /app/domain/target/domain-0.0.1-SNAPSHOT.jar domain.jar
COPY --from=builder /app/repository/target/repository-0.0.1-SNAPSHOT.jar repository.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
