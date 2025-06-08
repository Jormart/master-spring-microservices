# Master Microservices with Spring Boot and Spring Cloud

This repository contains all guided projects and practical exercises from the course **"Master Microservices with Spring Boot and Spring Cloud"**. Each project demonstrates key concepts and best practices for building robust microservices using Spring Boot, Spring Cloud, Docker, and related technologies.

## Repository Structure

- `restful-web-services/`  
  Build RESTful APIs with Spring Boot, including user management, filtering, versioning, and internationalization examples.
- `currency-exchange-service/`  
  Microservice for providing currency exchange rates, with H2 in-memory database and Spring Data JPA.
- `currency-conversion-service/`  
  Microservice for currency conversion, consuming the currency exchange service via RestTemplate and Feign, with Eureka service discovery.
- `limits-service/`  
  Demonstrates configuration management with Spring Cloud Config Server.
- `spring-cloud-config-server/`  
  Centralized configuration server for all microservices, using a local Git-backed repository (`git-localconfig-repo/`).
- `git-localconfig-repo/`  
  Local Git repository containing configuration files for all microservices.
- `naming-server/`  
  Eureka Naming Server for service discovery among microservices.
- `api-gateway/`  
  Spring Cloud API Gateway for routing and filtering requests to microservices.
- `docker-hello-world-java/`  
  Example Spring Boot app for Dockerization and container best practices.
- `04.docker/`  
  Docker and Docker Compose files for running the microservices ecosystem locally, including step-by-step and backup configurations.
- `doc/`  
  Documentation and course presentation slides.

## Getting Started

### Prerequisites
- Java 17 or higher (Java 21 recommended)
- Maven 3.6+
- Docker (for containerization and Docker Compose)
- An IDE such as VS Code or IntelliJ IDEA

### Running a Project (Locally)
1. Navigate to the project directory (e.g., `currency-exchange-service`).
2. Build the project:
   ```powershell
   ./mvnw clean install
   ```
3. Run the application:
   ```powershell
   ./mvnw spring-boot:run
   ```
   Or, run the generated JAR file:
   ```powershell
   java -jar target/<project-name>-0.0.1-SNAPSHOT.jar
   ```

### Running with Docker Compose
1. Navigate to the `04.docker` directory.
2. Start all services:
   ```powershell
   docker compose up --build
   ```
3. Stop all services:
   ```powershell
   docker compose down
   ```

### Useful Endpoints
- Eureka Dashboard: [http://localhost:8761](http://localhost:8761)
- H2 Console (for services using H2): [http://localhost:<port>/h2-console](http://localhost:<port>/h2-console)
- API Gateway: [http://localhost:8765](http://localhost:8765)
- Example REST endpoints: `/users`, `/currency-exchange/from/{from}/to/{to}`, `/currency-conversion/from/{from}/to/{to}/quantity/{quantity}`

### Configuration
- Centralized configuration is managed by `spring-cloud-config-server` and the `git-localconfig-repo` folder.
- Each service can be configured to run on a different port via its `application.properties`.

## Projects Overview
- **restful-web-services**: RESTful APIs, filtering, versioning, and internationalization.
- **currency-exchange-service**: Currency exchange rates microservice.
- **currency-conversion-service**: Currency conversion microservice with Feign and Eureka.
- **limits-service**: Demonstrates externalized configuration.
- **spring-cloud-config-server**: Centralized configuration server.
- **naming-server**: Eureka Naming Server for service discovery.
- **api-gateway**: API Gateway for routing and filtering.
- **docker-hello-world-java**: Example Spring Boot app for Docker.

## Resources
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Cloud Documentation](https://spring.io/projects/spring-cloud)
- [Docker Documentation](https://docs.docker.com/)

## License
This repository is for educational purposes as part of the "Master Microservices with Spring Boot and Spring Cloud" course.
