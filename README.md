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
- **Response**:
  ```json
  {
  "result": 15
  }


## Supported Operations:
ADD
SUBTRACT
MULTIPLY
DIVIDE

### **2. Perform a Chained Calculation**

- **Endpoint**: `/api/chain`
- **Method**: `POST`
- **Request**:
  ```json
  {
  "initialValue": 10,
  "operations": ["ADD", "MULTIPLY"],
  "operands": [5, 2]
  }
- **Response**:
  ```json
  {
  "result": 30
  }


## Validation
- **The operation field must be one of the supported operations: ADD, SUBTRACT, MULTIPLY, DIVIDE.**
- **Division by zero is not allowed and will return a 400 Bad Request with an error message.**

## Global Exception Handling
- **Invalid Operations: Returns a 400 Bad Request with a meaningful error message.**
- **Division by Zero: Returns a 400 Bad Request with a message: Division by zero is not allowed.**
- **Generic Errors: Returns a 500 Internal Server Error with a standard error message.**

## Setup and Run
- Prerequisites
- **JDK 17 or higher**
- **Maven**
- **Postman (optional for API testing)** 
- **Clone the repository:**
bash
Copy code
git clone https://github.com/hzqldjb/calculator.git
- **Build the project:**
bash
Copy code
mvn clean install
- **Run the application:**
bash
Copy code
mvn spring-boot:run
Access the API at http://localhost:8080/api.
## Testing
- Unit Tests
- The project includes unit tests for service and controller layers.
- **Run tests with:**
bash
Copy code
mvn test
## Postman Testing
- **Import the provided Postman collection (if available).**
- **Test endpoints directly via Postman.**
## Future Improvements
- Add support for advanced mathematical operations (e.g., exponentiation, square root).
- Implement user authentication and role-based access.
- Enhance logging for better traceability.

