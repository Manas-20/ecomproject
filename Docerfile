FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy Maven dependencies and application source
COPY pom.xml .
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/ecomproject-0.0.1-SNAPSHOT.jar"]
