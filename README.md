# Project README

## Overview
This project is a Spring Boot application exposing product-related REST endpoints. Controller location: `src/main/java/com/hsbc/controller/ProductController.java`. Service: `com.hsbc.service.ProductService`. Entities live under `com.hsbc.entity`.

## Running
\- Build with Maven:
\`\``
mvn clean package
\`\``
\- Run:
\`\``
mvn spring-boot:run
\`\`\`

## REST Endpoints (from `ProductController`)
Base path: `\/products`

\- `GET \/products`  
\- Description: Retrieve all products.  
\- Response: HTTP 200 with JSON array of `Product` objects.  
\- Example curl:
\`\``
curl -X GET http://localhost:8080/products
\`\`\`

\- `POST \/products`  
\- Description: Create a new product. Request body is a `Product` JSON.  
\- Request: HTTP 201 (or 200 depending on service) with created `Product` JSON.  
\- Example curl:
\`\``
curl -X POST http://localhost:8080/products \
-H "Content-Type: application/json" \
-d '{"name":"Example Product","price":19.99,"description":"Short desc"}'
\`\`\`

## Entity structure (locations)
\- `com.hsbc.entity.Product`  
\- `com.hsbc.entity.Student` (present in imports but not used in controller)

### Suggested / inferred `Product` structure
Fields are inferred from common patterns; adjust to match the actual entity class:
```java
Long id;
String name;
BigDecimal price;
String description;
Instant createdAt;
