# 📘 Spring Security User Login (MySQL + Spring Boot 3.5.7)

This project delivers a streamlined authentication workflow powered by **Spring Security**, **Spring Boot**, and a **MySQL-backed user identity store**.  
It demonstrates a real-world credential verification pipeline using a DAO-based authentication provider, custom `UserDetailsService`, and JPA-based entity management.

This implementation is ideal for learners building foundational security concepts — and for recruiters evaluating full-stack or backend readiness.

---

## 🚀 Key Features
- End-to-end authentication using Spring Security  
- DAO-based credential validation (no in-memory auth)  
- Custom `UserDetailsService` bound to JPA repository  
- MySQL-backed `Users` table as the single identity source  
- Simple role assignment via `UserPrincipal`  
- Minimal REST controller to validate authenticated entry  
- Spring Boot 3.5.7 with Java 21  

---

## 🛠 Tech Stack
| Layer | Technology |
|-------|------------|
| Backend Runtime | Spring Boot 3.5.7 |
| Security | Spring Security |
| ORM | Spring Data JPA |
| Database | MySQL 8.0 |
| Build Tool | Maven |
| Language | Java 21 |

---

## 🧩 Architecture Overview
```
Client Request
      |
      |  (username/password)
      v
Spring Security Filter Chain
      |
      |--> DaoAuthenticationProvider
      |       |
      |       |--> MyUserDetailsService
      |               |
      |               |--> UserRepository (JPA)
      |                       |
      |                       |--> Users Table (MySQL)
      |
      v
Authenticated Session
```

---

## 📦 Project Structure
```
src/main/java/com/login/user_login
│
├── config
│     └── SecurityConfig.java
│
├── controller
│     └── LoginController.java
│
├── entity
│     ├── Users.java
│     └── UserPrincipal.java
│
├── repo
│     └── UserRepository.java
│
└── service
      └── MyUserDetailsService.java
```

---

## 📚 Core Component Breakdown

### 🔐 SecurityConfig
Configures:
- DAO Authentication Provider  
- Custom UserDetailsService  
- No-Op Password Encoder (demo only)  

### 🧾 Users Entity
Represents the database user record with:
- `id`
- `username`
- `password`

### 🧩 UserPrincipal
Custom implementation of `UserDetails`.

### 🛠 MyUserDetailsService
Fetches user by username and hands off credentials to Spring Security during authentication.

### 🌐 LoginController
Protected endpoint:  
`GET /` → Returns a welcome message after successful authentication.

---

## 🗄 Database Schema (MySQL)

```sql
CREATE TABLE users (
    id BIGINT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);
```

Example record:
```sql
INSERT INTO users (id, username, password) VALUES (1, 'ganesh', '12345');
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository
```
git clone <your-repo-link>
```

### 2️⃣ Configure MySQL credentials
Inside `application.yml`:

```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/userdb
    username: root
    password: 123456
```

### 3️⃣ Create the table
Run the SQL schema provided above.

### 4️⃣ Start the Spring Boot application
```
mvn spring-boot:run
```

### 5️⃣ Test the secure endpoint
Visit:
```
http://localhost:8080/
```

Enter your MySQL-backed username and password when prompted.

---

## 🔒 Authentication Flow Summary
- User hits `/`  
- Spring Security intercepts  
- Credentials passed to DAO provider  
- `MyUserDetailsService` fetches user from DB  
- User authenticated → Response delivered  

---

## 📈 Future Enhancements
- Replace NoOp encoder → BCrypt  
- Add JWT-based authentication  
- Introduce RBAC/roles  
- Add login/logout endpoints  
- Add integration tests  

---

## 🌟 Why This Project Matters
This codebase demonstrates:
- Real DB-backed authentication  
- Practical Spring Security experience  
- Solid understanding of authentication lifecycle  
- Strong backend engineering fundamentals  

---

