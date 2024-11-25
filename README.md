# Calculator API

A simple and extensible calculator API built using Spring Boot that adheres to key object-oriented principles, including the Open-Closed Principle. This API supports basic arithmetic operations and is designed for maintainability, extensibility, and ease of testing.

---

## Features
1. **Basic Arithmetic Operations**: Supports addition, subtraction, multiplication, and division.
2. **Chaining Operations**: Allows sequential operations on a single value.
3. **Extensible Design**: Easily add new operations without modifying the core code.
4. **Validation**: Ensures only valid operations are processed.
5. **Global Exception Handling**: Centralized error management for cleaner code and consistent API responses.
6. **IoC Support**: Compatible with Inversion of Control for dependency injection.
7. **Tested**: Includes unit tests for both normal and edge cases.

---

## Technologies Used
- **Java 17**
- **Spring Boot 3.1.0**
- **Maven**
- **Postman** (for API testing)

---

## Endpoints

### **1. Perform a Basic Calculation**
- **Endpoint**: `/api/calculate`
- **Method**: `POST`
- **Request**:
  ```json
  {
    "operation": "ADD",
    "num1": 10,
    "num2": 5
  }
