# User Transaction Simulator

## Application Architecture

### Layers

1. **Presentation Layer**
   - **HTML/CSS/JavaScript (Frontend):**
     - User Interface for login, transaction history, and transactions.
     - Utilizes jQuery for AJAX requests.

2. **Application Layer**
   - **Spring Boot (Backend):**
     - **Controllers:**
       - Handle HTTP requests and manage the flow of data.
       - E.g., UserController, TransactionController.
     - **Services:**
       - Business logic and transaction handling.
       - E.g., UserService, TransactionService.

3. **Data Access Layer**
   - **Spring Data JPA:**
     - **Repositories:**
       - Interact with the database.
       - E.g., UserRepository, TransactionRepository.
     - **Entities:**
       - Java objects representing database tables.
       - E.g., User, Transaction.

### Communication

- **Frontend-Backend Interaction:**
  - AJAX requests using jQuery.
  - Endpoints defined in Spring controllers.

- **Backend-Database Interaction:**
  - Spring Data JPA repositories handle database operations.

## Workflow

1. **Login:**
   - User enters a username.
   - Frontend sends a request to the backend.
   - Backend retrieves user details and transaction history.

2. **Transaction History:**
   - Fetches and displays the user's transaction history.

3. **Perform Transaction:**
   - Validates the transaction.
   - Updates sender and receiver amounts.
   - Records the transaction.

## Conclusion

- Simple and intuitive user transaction simulation.
- Uses Spring Boot for backend and jQuery for frontend interaction.
- Clear separation of layers for maintainability and scalability.

## To-Do List

### 1. Security Measures:
   - Implement user authentication and authorization.
   - Apply input validation and prevent common vulnerabilities.
   - Ensure secure data transmission (HTTPS).
   - Protect against web attacks (CSRF, XSS).

### 2. Additional Features:
   - Transaction categorization.
   - Search and filtering for transaction history.
   - Notifications for successful transactions.

### 3. Dynamic Access for Multiple Users:
   - Implement user sessions for state management.
   - Ensure data isolation between users.
   - Allow secure switching between accounts.

### 4. Create Docker Image:
   - Write a Dockerfile for the application environment.
   - Build and test the Docker image locally.
   - Publish the Docker image to a container registry.
