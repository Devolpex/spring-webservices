FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Give executable permissions to mvnw
RUN chmod +x mvnw

# Build the application
RUN ./mvnw package -DskipTests

# Use the correct JAR filename from your target directory
COPY target/backend-0.0.1.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]