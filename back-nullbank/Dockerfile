FROM openjdk:11-jdk

WORKDIR /home/user/app/

COPY target/back-nullbank-0.0.1-SNAPSHOT.jar /home/user/app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "back-nullbank-0.0.1-SNAPSHOT.jar"]