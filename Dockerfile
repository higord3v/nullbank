FROM eclipse-temurin:17

LABEL mentainer="higord3v"

WORKDIR /home/user/app

COPY . .

ENTRYPOINT ["java", "-jar", "back-nullbank-0.0.1-SNAPSHOT.jar"]