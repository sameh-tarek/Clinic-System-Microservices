# Clinic System Microservices Project

![microservices-6-dark](https://github.com/user-attachments/assets/5cd5af7c-a10d-4003-bef4-38bad1d74ac7)

## Overview
This project is built using **Spring Boot Microservices Architecture**. It consists of the following services:

- **Doctor Service**: Handles all operations related to doctors.
- **Patient Service**: Manages patient-related functionalities.
- **Payment Service**: Manages payments and billing functionalities.
- **API Gateway**: Acts as a single entry point for all client requests and routes them to the appropriate service.
- **Eureka Server**: Service registry for discovering services.
- **Admin Server**: Monitors the status and health of the microservices.
- **Resilience4j Circuit Breaker**: Provides fault tolerance and resilience for microservices by implementing the circuit breaker pattern.


## Tech Stack
- **Java 17**
- **Spring Boot**
- **Spring Cloud**
  - **Spring Cloud Gateway** for API Gateway.
  - **Spring Cloud Netflix Eureka** for service discovery.
  - **Spring Cloud OpenFeign** for inter-service communication.
  - **Spring Boot Admin Server** for monitoring microservices.
  - **Resilience4j** for circuit breaker and resilience patterns.
- **Docker** for containerizing microservices.
- **Kubernetes** for orchestrating microservices.

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
  
  ![Screenshot (1175)](https://github.com/user-attachments/assets/38b88e9e-8895-49ba-9717-263dec9b92d4)

  ![Screenshot (1176)](https://github.com/user-attachments/assets/269969ce-6793-4112-a84f-27154f00a760)

  ![Screenshot (1177)](https://github.com/user-attachments/assets/dc6245d5-14d8-4a3f-8557-b55603b70c40)

  ![Screenshot (1178)](https://github.com/user-attachments/assets/84778165-4b2c-464d-8350-1377ef8756de)


### Resilience4j & Circuit Breaker
This project uses **Resilience4j** for fault tolerance and resilience. The **Circuit Breaker** pattern is implemented to prevent failures from cascading across the microservices when dependent services are down or experiencing high latency.

#### Circuit Breaker Configuration:
- **Failure Rate Threshold**: If 50% of the requests fail, the circuit will open.
- **Wait Duration in Open State**: The circuit will remain open for 3 seconds before transitioning to half-open.
- **Permitted Calls in Half-Open State**: 2 calls are allowed to test if the underlying service is up.
- **Sliding Window Type**: The failure rate is calculated based on a count of 10 recent calls.
  
 ![Screenshot (1179)](https://github.com/user-attachments/assets/d7d6c048-3c26-4b3e-9a8a-049defe9f09b)

### Docker & Kubernetes:
- **Docker** is used to containerize each microservice, ensuring consistency across environments and simplifying deployment.
- **Kubernetes** is used for managing and orchestrating the microservices. It automates deployment, scaling, and management of containerized applications.

![Screenshot (1183)](https://github.com/user-attachments/assets/b674c33c-5181-4369-88f7-53b7132fa107)
![Screenshot (1184)](https://github.com/user-attachments/assets/6ba66766-ea21-42ef-97a5-a0ad7989a9d7)
![Screenshot (1185)](https://github.com/user-attachments/assets/4f85ea6c-5de3-441c-9cfe-5d0072d19596)
![Screenshot (1182)](https://github.com/user-attachments/assets/6bea2f60-3101-476e-9c92-39eb173da697)

