# Master Microservices with Spring Boot and Spring Cloud

This repository contains all guided projects from the course **"Master Microservices with Spring Boot and Spring Cloud"**. Each project demonstrates key concepts and best practices for building robust microservices using Spring Boot and Spring Cloud.

## Repository Structure

- `restful-web-services/`  
  Build RESTful APIs with Spring Boot, including user management and hello world examples.
- `currency-exchange-service/`  
  Microservice for providing currency exchange rates, with H2 in-memory database and Spring Data JPA.
- `currency-conversion-service/`  
  Microservice for currency conversion, consuming the currency exchange service.
- `limits-service/`  
  Microservice for demonstrating configuration management with Spring Cloud Config Server.
- `spring-cloud-config-server/`  
  Centralized configuration server for all microservices, using a local Git-backed repository (`git-localconfig-repo/`).
- `git-localconfig-repo/`  
  Local Git repository containing configuration files for all microservices.
- `naming-server/`  
  Eureka Naming Server for service discovery among microservices.
- `doc/`  
  Documentation and course presentation slides.

## Getting Started

### Prerequisites
- Java 17 or higher (Java 21 recommended)
- Maven 3.6+
- An IDE such as VS Code or IntelliJ IDEA

### Running a Project
1. Navigate to the project directory (e.g., `currency-exchange-service`).
2. Install dependencies and build the project:
   ```bash
   ./mvnw clean install
   ```
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
   Or, run the generated JAR file:
   ```bash
   java -jar target/<project-name>-0.0.1-SNAPSHOT.jar
   ```

### Running Multiple Microservices
- Each microservice can be run on a different port by setting `server.port` in its `src/main/resources/application.properties`.
- The `spring-cloud-config-server` should be started first if you want to use centralized configuration.
- The `git-localconfig-repo/` contains the configuration files used by the config server.
- The `naming-server` (Eureka) should be started before other services that require service discovery.

### H2 Database Console
- Access the H2 console at `http://localhost:<port>/h2-console` for services using H2.
- Default JDBC URL: `jdbc:h2:mem:testdb`

## Projects

- **restful-web-services**: Build and test RESTful web services with Spring Boot.
- **currency-exchange-service**: Provides currency exchange rates.
- **currency-conversion-service**: Converts currencies using exchange rates from the exchange service.
- **limits-service**: Demonstrates externalized configuration with Spring Cloud Config.
- **spring-cloud-config-server**: Centralized configuration server for all microservices.
- **naming-server**: Eureka Naming Server for service discovery.

## Resources
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Cloud Documentation](https://spring.io/projects/spring-cloud)

## License
This repository is for educational purposes as part of the "Master Microservices with Spring Boot and Spring Cloud" course.
