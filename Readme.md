# FlowUsers

A simple RESTful API for user management built with Spring Boot.

---

## Features

- CRUD operations for users.
- Input validation with `javax.validation`.
- DTOs for clean layer separation.
- Centralized error handling with `@ControllerAdvice`.

---

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- MySQL Driver
- Maven
---

## Setup & Run

1. Clone the repository:
```bash
git clone https://github.com/martinfiguerola/userflow-api.git
```
2. Navigate to the project directory: 
```bash
cd userflow-api
```
3. Run the application:
```bash
mvn spring-boot:run
```
4. The API will be available at [http://localhost:8080](http://localhost:8080)

---

## API Endpoints

---

### `POST /api/users`

#### Description
This endpoint creates a new user in the database.

#### Request Body:
```json 
{
  "name": "john",
  "email": "john.doe@example.com",
  "password": "securePassword123"
}
```

#### Successful Response `201 CREATED`

```json
{
  "id": 1,
  "name": "john",
  "email": "john.doe@example.com"
}
```

#### Possible Errors 
- `400 Bad Request`: When required data is missing or the format is incorrect.

---

### `GET /api/users`

#### Description
This endpoint returns a list of all registered users in the system.

#### Parameters
This endpoint does not require any parameters.

#### Successful Response `200 OK`

```json
[
  {
    "id": 1,
    "name": "john",
    "email": "john.doe@example.com"
  }
]
```
#### Possible Errors
- `500 Internal Server Error`: Unexpected server error.

---

### `PUT /api/users/{id}`

#### Description
Updates an existing user by ID with the provided name, email, and password.

#### Parameters
| Name | Type | Location | Description              | Required |
|------|------|----------|--------------------------|----------|
| id   | Long | Path     | ID of the user to update | Yes      | 

#### Request Body

```json 
{
  "name": "New Name",
  "email": "new.email@example.com",
  "password": "newPassword123"
}

```

#### Successful Response `200 OK`

```json
{
  "id": 31,
  "name": "New Name",
  "email": "new.email@example.com"
}
```
#### Possible Errors
- `404 Not Found`: User with the given ID does not exist.
- `400 Bad Request`: Invalid input.


## 📄 License
This project is open-source and available under the MIT License.

