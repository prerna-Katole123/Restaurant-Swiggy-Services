# Restaurant-Swiggy-Services

A backend food order management system for restaurant services inspired by Swiggy, built with Java and Spring Boot.  
This project demonstrates microservice architecture with REST API communication using RestTemplate.

## Project Structure

- **RestaurantService** (port 8080): Exposes REST APIs for restaurant and menu management.
- **SwiggyService** (port 8081): Acts as the client, managing orders and communicating with RestaurantService via HTTP REST calls.

## Features

- Restaurant CRUD operations
- Menu CRUD operations
- Order placement and tracking
- RESTful API between services using RestTemplate

## Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA (for persistence)
- H2/MySQL/PostgreSQL (configurable database)
- Maven

## Getting Started

### Prerequisites

- Java JDK 17+ installed
- Maven installed

### Installation

Clone the repository:
```bash
git clone https://github.com/prerna-Katole123/Restaurant-Swiggy-Services.git
cd Restaurant-Swiggy-Services
```

### Running the Services

#### 1. Start RestaurantService

```bash
cd RestaurantService
mvn spring-boot:run
```
Service runs on `http://localhost:8080`

#### 2. Start SwiggyService

```bash
cd ../SwiggyService
mvn spring-boot:run
```
Service runs on `http://localhost:8081`

### API Endpoints

**RestaurantService (8080):**
- `GET /api/restaurants` - List all restaurants
- `GET /api/restaurants/{id}` - Get restaurant details
- `GET /api/restaurants/{id}/menu` - Get menu for a restaurant
- `POST /api/restaurants` - Add new restaurant
- `POST /api/restaurants/{id}/menu` - Add menu item

**SwiggyService (8081):**
- `POST /api/orders` - Place order (communicates with RestaurantService)
- `GET /api/orders/{orderId}` - Get order status

> See code for full API details and request/response formats.

## Configuration

Both services use `application.properties` for configuration (ports, DB, etc).  
For development, H2 in-memory DB can be used.

## Testing

Run unit tests with:
```bash
mvn test
```

## Contributing

Contributions are welcome! Open an issue or submit a pull request.

## License

MIT License

## Author

[prerna-Katole123](https://github.com/prerna-Katole123)

---

*This README is for the backend only. Frontend integration instructions will be added later.*
