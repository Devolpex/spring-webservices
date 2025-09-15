FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app
COPY target/*.jar app.jar

EXPOSE 8080
EXPOSE 8090
EXPOSE 9000

ENV SPRING_PROFILES_ACTIVE=dev

# Run the JAR file with dynamic environment variables
ENTRYPOINT ["java","-jar", "app.jar"]
