# Stage 1: Build the application
FROM eclipse-temurin:21-jdk-alpine AS build

# Set the volume for the temporary directory
VOLUME /tmp

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Install the dependencies and build the application
RUN ./mvnw clean compile install -DskipTests -Pprod

# Stage 2: Create the final image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Define build arguments
ARG SPRING_DATASOURCE_URL
ARG SPRING_DATASOURCE_PASSWORD
ARG CORS_ALLOWED_ORIGINS
# Set environment variables from build arguments
ENV SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL}
ENV SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME}
ENV SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}
ENV CORS_ALLOWED_ORIGINS=${CORS_ALLOWED_ORIGINS}

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port
EXPOSE 8082
EXPOSE 9090

# Run the JAR file
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
