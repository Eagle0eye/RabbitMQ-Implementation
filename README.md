Here's a simplified version of the README without the guide:

---

# RabbitMQ and Spring Boot Integration

This project demonstrates how to integrate **RabbitMQ** with a **Spring Boot** application for message queuing and asynchronous processing.

## Features

- REST API for creating and retrieving products
- **RabbitMQ Producers** for sending messages
- **RabbitMQ Consumers** for receiving and processing messages
- Simple in-memory product data

## Getting Started

### Prerequisites

- **RabbitMQ** running locally (can use Docker)
- **Java 11+** and **Maven**

### Running the Application

1. **Start RabbitMQ**  
   You can run RabbitMQ using Docker:
   ```bash
   docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
   ```
   RabbitMQ Management UI is available at [http://localhost:15672](http://localhost:15672) (default username/password: `guest/guest`).

2. **Clone the Repository**
   ```bash
   git clone https://github.com/Eagle0eye/RabbitMQ-Implementation.git
   cd RabbitMQ-Implementation
   ```

3. **Run the Spring Boot Application**
   ```bash
   mvn spring-boot:run
   ```

4. **Test the API Endpoints**
   - **POST** `/api/v1/products/create` to create a product.
   - **GET** `/api/v1/products` to retrieve all products.
   - **GET** `/api/v1/products/{id}` to retrieve a specific product by ID.

## Links

- **Medium Post**: [RabbitMQ and Spring Boot Integration - A Practical Guide](https://medium.com/@yousef.mohamed.12/rabbitmq-and-spring-boot-integration-a-practical-guide-e59222bed429)
- **GitHub Repository**: [RabbitMQ-Implementation](https://github.com/Eagle0eye/RabbitMQ-Implementation)

## License

This project is **free to use** and distributed under the **MIT License**.

---

Let me know if that works!
