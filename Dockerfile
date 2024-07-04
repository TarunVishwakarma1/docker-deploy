# Use the official Gradle image with JDK 17 for building
FROM gradle:7.5-jdk17 AS build

# Set the working directory
WORKDIR /app

# Copy Gradle configuration files
COPY build.gradle settings.gradle /app/

# Copy source code
COPY src /app/src

# Run the Gradle build
RUN gradle clean bootJar --no-daemon

# Check if the JAR file is present after the build
RUN ls -l /app/build/libs/

# Use the official Eclipse Temurin JDK 21 image for the runtime
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

# Copy the built application
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Diagnostic: List files in the /app directory
RUN ls -l /app

# Expose the application port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/app.jar"]
