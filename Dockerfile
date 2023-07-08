FROM eclipse-temurin:17

LABEL mentainer="higord3v"

WORKDIR /usr/src/app

COPY ./back-nullbank/target/back-nullbank-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["java", "-jar", "back-nullbank-0.0.1-SNAPSHOT.jar"]