# Exception Handling Demo

This project demonstrates exception handling in a Spring Boot application. It includes custom exceptions, global exception handling, and integration with external APIs using `RestTemplate`.

## Technologies Used

- Java
- Spring Boot
- Maven

## Project Structure

- `src/main/java/com/example/demo/exceptionhandling/`
    - `entity/`: Contains entity classes.
    - `exception/`: Contains custom exception classes.
    - `handler/`: Contains global exception handler.
    - `model/`: Contains data transfer objects (DTOs).
    - `repository/`: Contains repository interfaces.
    - `service/`: Contains service classes.
    - `util/`: Contains utility classes.
    - `ExceptionhandlingApplication.java`: Main application class.

## Custom Exceptions

- `DemoException`: Base exception class.
- `DemoAPIException`: Exception for API-related errors.
- `DemoDataException`: Exception for data-related errors.
- `DemoEventException`: Exception for event-related errors.

## Global Exception Handler

The `GlobalExceptionHandler` class handles exceptions globally using `@ControllerAdvice`. It provides specific handlers for custom exceptions and a general handler for other exceptions.

## Services

- `UserRegistrationService`: Handles user registration, including saving user data, invoking login    API, and publishing events.
- `LoginService`: Handles login operations and invokes the login API using `RestTemplate`.

## Running the Application

1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn clean install` to build the project.
4. Run `mvn spring-boot:run` to start the application.

## Endpoints

- `/api/auth/login`: Endpoint for user login.

## Exception Handling

The application uses `@ExceptionHandler` methods in the `GlobalExceptionHandler` class to handle exceptions and return appropriate HTTP status codes and messages.

## License

This project is licensed under the MIT License.