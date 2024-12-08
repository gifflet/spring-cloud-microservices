# Spring Cloud Microservices Project

## Overview

This project is a collection of microservices built using Spring Boot, designed to demonstrate the capabilities of microservices architecture. The system consists of several services, including a client management service, a card management service, a credit assessment service, and a cloud gateway for routing requests. Each service is registered with a Eureka server for service discovery.

## Architecture

The architecture of the project is based on the following components:

- **Eureka Server**: Acts as a service registry for all microservices.
- **Clients Service**: Manages client information.
- **Cards Service**: Handles card-related operations.
- **Credit Assessment Service**: Evaluates the creditworthiness of clients.
- **Cloud Gateway**: Routes requests to the appropriate microservice.

## Technologies Used

- Spring Boot
- Spring Cloud
- Spring Data JPA
- RabbitMQ
- H2 Database (for development)
- Lombok
- MapStruct
- Feign Client

## Getting Started

### Prerequisites

- Java 17
- Maven
- Docker (optional, for running services in containers)

### Running the Application

You can run the application using Docker Compose. Make sure you have Docker installed and running, then execute the following command in the root directory of the project:
```bash
docker-compose up --build
```

This command will build and start all the microservices along with the RabbitMQ and Keycloak services.

### Accessing the Services

Once the services are up and running, you can access them through the Cloud Gateway. The default port for the gateway is `8080`.

## How to Use

### Client Management

1. **Create a Client**

   To create a new client, send a POST request to the `/clients` endpoint:

   ```bash
   curl -X POST http://localhost:8080/clients \
   -H "Content-Type: application/json" \
   -d '{
       "cpf": "12345678900",
       "name": "John Doe",
       "age": 30
   }'
   ```

2. **Find a Client by CPF**

   To retrieve a client by their CPF, send a GET request to the `/clients` endpoint:

   ```bash
   curl -X GET "http://localhost:8080/clients?cpf=12345678900"
   ```

### Card Management

1. **Create a Card**

   To create a new card, send a POST request to the `/cards` endpoint:

   ```bash
   curl -X POST http://localhost:8080/cards \
   -H "Content-Type: application/json" \
   -d '{
       "name": "Visa",
       "brand": "Visa",
       "income": 5000,
       "creditLimit": 1000
   }'
   ```

2. **Get Cards by CPF**

   To retrieve cards associated with a specific CPF, send a GET request to the `/cards` endpoint:

   ```bash
   curl -X GET "http://localhost:8080/cards?cpf=12345678900"
   ```

### Credit Assessment

1. **Assess Credit**

   To assess a client's credit, send a POST request to the `/credit-assessments` endpoint:

   ```bash
   curl -X POST http://localhost:8080/credit-assessments \
   -H "Content-Type: application/json" \
   -d '{
       "cpf": "12345678900",
       "income": 3000
   }'
   ```

2. **Get Customer Cards**

   To retrieve the cards associated with a customer after assessment, send a GET request to the `/credit-assessments/customer-cards` endpoint:

   ```bash
   curl -X GET "http://localhost:8080/credit-assessments/customer-cards?cpf=12345678900"
   ```

## Conclusion

This project demonstrates the integration of multiple microservices using Spring Cloud. Each service can be independently developed, deployed, and scaled, providing flexibility and resilience. For further customization and enhancements, feel free to explore the codebase and contribute!