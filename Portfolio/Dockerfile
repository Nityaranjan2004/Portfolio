# Build stage
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
# Download dependencies first (cached layer)
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests -B

# Run stage
FROM eclipse-temurin:17-jre-alpine

# Add a non-root user and group for security
RUN addgroup -S spring && adduser -S spring -G spring

# Configure a directory for temporary files
VOLUME /tmp

WORKDIR /app
COPY --from=build /app/target/Portfolio-0.0.1-SNAPSHOT.jar app.jar

# Ensure the application runs as the non-root user
USER spring:spring

# Set default server port environment variable
ENV SERVER_PORT=8091
EXPOSE 8091

# Configure production-ready JVM flags (e.g., container support, memory settings)
ENTRYPOINT ["java", "-XX:+UseG1GC", "-XX:+UseContainerSupport", "-jar", "app.jar"]

