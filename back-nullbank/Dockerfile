FROM openjdk:11-jdk

WORKDIR /usr/app

COPY target/back-nullbank-0.0.1-SNAPSHOT.jar /usr/app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "back-nullbank-0.0.1-SNAPSHOT.jar"]