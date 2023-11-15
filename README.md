# E-Commerce Spring Boot Application

This is a simple e-commerce platform built using Spring Boot and REST services. The application allows users to browse products, add items to their cart, and place orders. It also integrates with a payment gateway (e.g., PayPal or Stripe) for processing payments.

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Database Configuration](#database-configuration)
- [Running Tests](#running-tests)
- [Endpoints](#endpoints)
- [Security](#security)
- [Payment Gateway Integration](#payment-gateway-integration)
- [Contributing](#contributing)
- [License](#license)

## Features

- Browse products
- Add items to the cart
- Place orders
- Payment processing with a chosen payment gateway (e.g., Stripe or PayPal)
- User authentication and authorization
- Unit and integration tests

## Prerequisites

- Java 8 or higher
- Maven or Gradle build tool
- Your preferred code editor (e.g., IntelliJ IDEA, Eclipse)

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/e-commerce-spring-boot.git
   cd e-commerce-spring-boot
    ```
   
2. Run the application:

   ```bash
   mvn spring-boot:run
   ```
   
3. Open your browser and navigate to `http://localhost:8080`.

## Configuration

The application can be configured by modifying the `application.properties` file located in the `src/main/resources` directory. The following table lists the configurable properties:

## Database Configuration

The application uses an in-memory H2 database by default. To use a different database, you need to add the corresponding dependency to the `pom.xml` file and update the `application.properties` file accordingly. For example, to use MySQL, you need to add the following dependency:


## Running Tests

To run the unit and integration tests, execute the following command:

```bash
./gradlew test
```

## Endpoints

The following table lists the available endpoints:


## Security

The application uses Spring Security for authentication and authorization. The following table lists the default credentials:


## Payment Gateway Integration

The application integrates with a payment gateway (e.g., Stripe or PayPal) for processing payments. The following table lists the available payment methods:


## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
