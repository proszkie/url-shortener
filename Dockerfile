FROM openjdk:11-jdk-slim

ARG UID=2000
ARG GID=2001

RUN groupadd -g $GID application
RUN useradd -m -u $UID -g application application
USER application
WORKDIR /home/application

COPY --chown=application:application build/libs/*.jar ./

EXPOSE 8080
CMD java -jar *.jar


