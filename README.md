
# Banking Ledger

A springboot based backend service to manage user ledgers and transactions. It allows to create ledgers, add financial transactions and retrieve records.


## Technologies Used

Java\
Spring Boot\
Spring Data JPA\
MySQL\
Maven\
Postman
## Project Structure

```plaintext
src/main/java/com/banking/ledger/
├── Controllers/
│   └── LedgerController.java       # REST API endpoints
├── Models/
│   ├── Ledger.java                 # Ledger entity
│   └── Transaction.java            # Transaction entity
├── Repository/
│   ├── LedgerRepository.java       # Ledger data layer
│   └── TransactionRepository.java  # Transaction data layer
├── Services/
│   └── LedgerService.java          # Logic layer
└── LedgerApplication.java          # Main application class
```
## Database

### Ledgers Table

| Column     | Type    | Description                    |
| ---------- | ------- | ------------------------------ |
| `id`       | BIGINT  | Primary Key (Auto-generated)   |
| `userId`   | BIGINT  | User identifier                |
| `currency` | VARCHAR | Currency type (USD, EUR, etc.) |
| `bank`     | VARCHAR | Bank name                      |

### Transactions Table

| Column        | Type     | Description                     |
| ------------- | -------- | ------------------------------- |
| `id`          | BIGINT   | Primary Key (Auto-generated)    |
| `amount`      | DOUBLE   | Transaction amount              |
| `type`        | VARCHAR  | Transaction type (debit/credit) |
| `description` | VARCHAR  | Transaction description         |
| `timestamp`   | DATETIME | Transaction timestamp           |
| `ledger_id`   | BIGINT   | Foreign Key to `ledgers(id)`    |



## Installation

Clone the repository

```bash
  git clone <repository-url>
  cd banking-ledger
```
Create MySQL database

```sql
  CREATE DATABASE ledger_database;
```

Configure database connection

Update 
```src/main/resources/application.properties:```

```properties
spring.application.name=ledger

spring.datasource.url=jdbc:mysql://localhost:3306/ledger_database
spring.datasource.username=root
spring.datasource.password=your_password_here

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
Build and Run

```bash
  # Build the project
  mvn clean compile

  # Run the application
  mvn spring-boot:run
```


## Software Architecture Considerations

Built stateless RESTful APIs using Spring Boot, which allows for easy horizontal scaling and have used repository-level queries (findByUserId, findByLedgerId) for efficient data access.

Applied validation using @Valid, @NotNull, and @NotBlank annotations to prevent invalid or empty input.

Captured timestamp on each transaction to track activity.

Created a dedicated Ledger Service responsible for managing ledgers and their transactions.
## API Reference

### Ledger APIs

| Method | Endpoint     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `POST`      | `/api/ledgers` | Create a new ledger |
| `GET`      | `/api/ledgers/{ledgerId}` | Get a ledger by ID |
| `GET`      | `/api/users/{userId}/ledgers` | Get all ledgers for a user |

### Transaction APIs

| Method | Endpoint     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `POST`      | `/api/ledgers/{ledgerId}/transactions` | Add a transaction to a ledger  |
| `GET`      | `/api/ledgers/{ledgerId}/transactions` | Get all transactions in a ledger |

