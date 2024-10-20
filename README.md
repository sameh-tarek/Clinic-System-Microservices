# Clinic System Microservices Project

## Overview
This project is built using **Spring Boot Microservices Architecture**. It consists of the following services:

- **Doctor Service**: Handles all operations related to doctors.
- **Patient Service**: Manages patient-related functionalities.
- **Payment Service**: Manages payments and billing functionalities.
- **API Gateway**: Acts as a single entry point for all client requests and routes them to the appropriate service.
- **Eureka Server**: Service registry for discovering services.
- **Admin Server**: Monitors the status and health of the microservices.

## Tech Stack
- **Java 17**
- **Spring Boot**
- **Spring Cloud**
  - **Spring Cloud Gateway** for API Gateway.
  - **Spring Cloud Netflix Eureka** for service discovery.
  - **Spring Cloud OpenFeign** for inter-service communication.
  - **Spring Boot Admin Server** for monitoring microservices.

## Microservices Architecture
Each service is independent and has its own responsibilities. Services communicate using HTTP REST APIs via Feign clients. The **Eureka Server** enables dynamic service discovery.


### API Gateway:
- The **API Gateway** routes client requests to the respective microservices. It uses **Spring Cloud Gateway** for routing and filtering incoming requests.
- Sample routes:
  - `/doctor/**` -> **Doctor Service**
  - `/patient/**` -> **Patient Service**
  - `/payment/**` -> **Payment Service**

### Eureka Server:
- **Eureka Server** acts as the service registry. Each service registers itself to **Eureka** for discovery, making it easier for services to communicate dynamically without hardcoded IP addresses.
![Screenshot (1174)](https://github.com/user-attachments/assets/748c81e2-bae1-4265-a43d-32dc32d62196)

### Admin Server:
- The **Admin Server** monitors the status and health of the microservices. It provides real-time information about the running status, memory usage, and other health metrics of the services.
- **URL**: `http://localhost:8888`
  
  The **Admin Server** dashboard gives an overview of:
  - Service up/down status.
  - Metrics like memory, CPU usage, and heap space.
  - Service logs, thread dumps, and more.