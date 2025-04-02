# Use a lightweight JDK base image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy the Maven project files
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the complete project source
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/ecomproject-0.0.1-SNAPSHOT.jar"]