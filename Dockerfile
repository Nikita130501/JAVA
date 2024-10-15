# Используем базовый образ с OpenJDK 17
FROM openjdk:17-jdk-alpine

# Указываем аргумент JAR_FILE, который будет содержать путь к jar-файлу
ARG JAR_FILE=target/*.jar

# Копируем jar-файл в контейнер под именем app.jar
COPY ${JAR_FILE} app.jar

# Указываем команду для запуска Spring Boot приложения
ENTRYPOINT ["java", "-jar", "/app.jar"]

