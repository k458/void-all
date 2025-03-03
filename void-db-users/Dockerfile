FROM openjdk:23-jdk-slim

WORKDIR /app

COPY ./target/void-db-users.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
