# BUILD PROJECT WITH GRADLE
###########################
FROM gradle:6.4.1-jdk11 AS build

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN ./gradlew bootJar --no-daemon

# RUN APP
###########################

FROM openjdk:11-jdk-slim

ARG UID=2000
ARG GID=2001

RUN groupadd -g $GID application
RUN useradd -m -u $UID -g application application
USER application
WORKDIR /home/application

COPY --from=build /home/gradle/src/build/libs/*.jar /app/app.jar

EXPOSE 8080
CMD java -jar -DshortenerHost=url-shortener-dev.eu-west-1.elasticbeanstalk.com /app/app.jar
