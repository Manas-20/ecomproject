# Use a lightweight JDK base image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the Maven wrapper and settings
COPY mvnw .
COPY .mvn .mvn

# Copy the Maven project files
COPY pom.xml .
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy the complete project source
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/ecomproject-0.0.1-SNAPSHOT.jar"]
