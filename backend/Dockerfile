# # Stage 1: Build the application
# FROM eclipse-temurin:21-jdk-alpine AS build

# # Set the working directory in the container
# WORKDIR /app

# # Copy the Maven project files
# COPY mvnw .
# COPY .mvn .mvn
# COPY pom.xml .
# COPY src src

# # Build the application using Maven
# RUN ./mvnw clean install -DskipTests

# Stage 2: Create the final image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Define build arguments
ARG DB_HOST
ARG DB_PORT
ARG DB_NAME
ARG DB_USER
ARG DB_PASSWORD
ARG CORS_ALLOWED_ORIGINS
ARG SPRING_PROFILES_ACTIVE

# Set environment variables from build arguments
ENV DB_HOST=${DB_HOST}
ENV DB_PORT=${DB_PORT}
ENV DB_NAME=${DB_NAME}
ENV DB_USER=${DB_USER}
ENV DB_PASSWORD=${DB_PASSWORD}
ENV CORS_ALLOWED_ORIGINS=${CORS_ALLOWED_ORIGINS}
ENV SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE}

# # Copy the JAR file from the build stage
# COPY --from=build /app/target/*.jar app.jar


COPY target/*.jar app.jar

# Expose the port
EXPOSE 8082
EXPOSE 9099

# Run the JAR file with dynamic environment variables
ENTRYPOINT ["java", \
            "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", \
            "-jar", "app.jar"]
