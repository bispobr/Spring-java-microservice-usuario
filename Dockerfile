FROM openjdk:21-ea-1-jdk-slim

WORKDIR /app

COPY target/usuario-0.0.1-SNAPSHOT.jar /app/usuario.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/usuario.jar"]