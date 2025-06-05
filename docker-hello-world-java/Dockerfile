FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /home/app

# Copy only pom.xml and download dependencies (for better build caching)
COPY pom.xml /home/app/pom.xml
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src /home/app/src

# Package the application
RUN mvn -f /home/app/pom.xml clean package

FROM eclipse-temurin:21-jdk-jammy
EXPOSE 5000
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]