FROM openjdk:17-jdk-alpine

# Устанавливаем bash
RUN apk add --no-cache bash

COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["/wait-for-it.sh", "db", "--", "java", "-jar", "/app.jar"]

