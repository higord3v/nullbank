#
# package
#
FROM maven:3.9.0-eclipse-temurin-17-alpine AS build

COPY . .

RUN cd ./back-nullbank && mvn clean package

#
# build
#
FROM openjdk:17

COPY --from=build ./back-nullbank/target/back-nullbank-0.0.1-SNAPSHOT.jar back-nullbank-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "back-nullbank-0.0.1-SNAPSHOT.jar"]