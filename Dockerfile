# 1-bosqich: build
FROM maven:3.9-eclipse-temurin-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q dependency:go-offline
COPY src ./src
RUN mvn -q -DskipTests package

# 2-bosqich: run
FROM eclipse-temurin:11-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
RUN mkdir -p /app/files
ENV FILES_DIR=/app/files
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
