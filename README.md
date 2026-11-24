
# Employee Management System – Backend

A RESTful backend application developed using Java and Spring Boot to manage employee records efficiently. The application implements CRUD operations using Spring Data JPA and follows a layered architecture with DTO (Data Transfer Object) to transfer data between client and server.

## 🚀 Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- DTO (Data Transfer Object)
- MySQL
- Maven
- REST API
- Postman
- IntelliJ IDEA

## ✨ Features

- Add a new employee
- Retrieve all employees
- Retrieve employee by ID
- Update employee details
- Delete employee by ID
- DTO-based request and response handling
- Database integration using Spring Data JPA
- Entity and DTO separation
- Exception handling for employee records


## ⚙️ Database Configuration

Create a database in MySQL:

```sql
CREATE DATABASE employee_management;
```

Configure `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 🔗 REST API Endpoints

Base URL:

```text
http://localhost:8080/api/employees
```

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/api/employees` | Add a new employee |
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| PUT | `/api/employees/{id}` | Update employee details |
| DELETE | `/api/employees/{id}` | Delete employee by ID |

## 📥 Sample JSON Request

Add Employee:

```json
{
  "firstName": "Rahul",
  "lastName": "Sharma",
  "email": "rahul@gmail.com",
  "department": "IT",
  "salary": 45000
}
```

*Note: JSON properties should match the fields defined in your EmployeeDTO.*

## 🏗️ Application Architecture

The project follows a layered architecture:

- **Controller Layer:** Handles incoming HTTP requests and returns API responses.
- **Service Layer:** Contains business logic and processes employee operations.
- **Repository Layer:** Interacts with the database using Spring Data JPA.
- **Entity Layer:** Represents employee data in the database.
- **DTO Layer:** Transfers employee data between the client and application without directly exposing entity objects.
- **Exception Layer:** Handles errors and resource-not-found scenarios.

## 🛠️ How to Run the Project

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Configure MySQL database credentials in `application.properties`.
4. Ensure MySQL server is running.
5. Update Maven dependencies.
6. Run `EmployeeManagementApplication.java`.
7. Test API endpoints using Postman.

## 🎯 Learning Outcomes

- Understanding Spring Boot REST API development.
- Implementing CRUD operations using Spring Data JPA.
- Understanding DTO pattern and its importance.
- Separating Entity and DTO layers.
- Implementing layered architecture.
- Connecting Spring Boot with MySQL.
- Handling exceptions in REST APIs.
- Working with Hibernate ORM.



⭐ If you find this project useful, don't forget to give it a star!
