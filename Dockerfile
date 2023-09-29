# Use an official OpenJDK runtime as a parent image
FROM adoptopenjdk:17-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container at /app
COPY target/your-spring-boot-app.jar .

# Expose port 8080 to the outside world
EXPOSE 8080

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "./app.jar"]
