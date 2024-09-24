# Use the official Maven image to build the application
FROM maven:3.8.5-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and install dependencies
COPY pom.xml .
COPY src ./src

# Package the application as a JAR
RUN mvn clean package -DskipTests

# Use a lightweight image for the final image
FROM openjdk:17-jdk-slim

# Set the working directory in the final image
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]