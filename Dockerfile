FROM eclipse-temurin:21-jdk

ARG GRADLE_VERSION=8.5

RUN apt-get update && apt-get install -yq unzip

WORKDIR /app

COPY /app .

RUN gradle bootJar

EXPOSE 8080

CMD java -jar build/libs/app-0.0.1-SNAPSHOT.jar
