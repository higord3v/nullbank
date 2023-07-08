FROM eclipse-temurin:17

LABEL mentainer="higord3v"

WORKDIR /app

COPY . .

ENTRYPOINT ["java", "-jar", "/app/back-nulllbank/target/back-nullbank-0.0.1-SNAPSHOT.jar"]