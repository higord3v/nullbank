FROM eclipse-temurin:17

LABEL mentainer="higord3v"

WORKDIR /app

COPY nullbank/back-nullbank/target/back-nullbank-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "back-nullbank-0.0.1-SNAPSHOT.jar"]