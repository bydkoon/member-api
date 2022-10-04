FROM openjdk:11-jdk-slim-sid AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew clean build --debug

FROM openjdk:11-jdk-slim-sid
VOLUME /tmp

ARG JAR_FILE=build/libs/asinsum-0.0.1.jar
COPY --from=builder ${JAR_FILE} app.jar

ENTRYPOINT java -Dspring.profiles.active=local -jar app.jar