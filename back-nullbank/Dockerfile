FROM openjdk:11-jdk
WORKDIR /home/app/
COPY target/back-nullbank-0.0.1-SNAPSHOT.jar /home/app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]