# Указываем базовый образ, содержащий OpenJDK и Maven для сборки проекта
FROM maven:3.1.1-openjdk-22 AS build

# Копируем исходный код проекта внутрь контейнера
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

# Задаем рабочую директорию
WORKDIR /usr/src/app

# Собираем проект с помощью Maven
RUN mvn clean package

# Задаем базовый образ, содержащий JRE
FROM openjdk:22-jre-slim

# Копируем собранный JAR-файл из предыдущего этапа внутрь контейнера
COPY --from=build /usr/src/app/target/*.jar /usr/app/app.jar

# Задаем порт, на котором будет работать приложение
EXPOSE 8080

# Запускаем приложение при старте контейнера
CMD ["java", "-jar", "/usr/app/app.jar"]
