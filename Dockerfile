FROM openjdk:17-alpine AS jre-build

WORKDIR /usr/app/
COPY ./build/libs/defeito-motor-eletrico-0.0.1-SNAPSHOT.jar ./defeito-motor-eletrico.jar

ENTRYPOINT exec java -jar defeito-motor-eletrico.jar
