FROM openjdk:11-jdk-slim
ARG JAR_FILE=build/libs/api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} api.jar
EXPOSE 8080
ENTRYPOINT exec java -Dspring.profiles.active=local -jar api.jar