# Employee Management System

A Spring Boot-based backend application to manage Employees, Departments, and Addresses with RESTful APIs. This project demonstrates entity relationships using JPA, handles validations, and provides complete CRUD operations.

## 🚀 Project Overview

This Employee Management System is designed to:

- Add, update, retrieve, and delete **Employees**
- Assign and manage **Departments** for employees (Many-to-Many relationship)
- Manage **Addresses** of employees (One-to-Many relationship)
- Use **Spring Boot**, **JPA (Hibernate)**, and **REST APIs**
- Enable clean JSON serialization using Jackson's `@JsonManagedReference` and `@JsonBackReference`

## 🔗 GitHub Repository

🔗 [Employee Management System](https://github.com/suyash7318/EmployeeManagement)

## 🛠 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- H2 / MySQL (switchable)
- Maven
- REST APIs
- Jackson (for JSON handling)
- Lombok (optional, not used here)

## 🔐 Security

- APIs are secured using **Spring Security**
- Basic Authentication is enabled by default
- Username and password can be configured in `application.properties`
- Only authenticated users can access endpoints


## 🔍 Relationships

- **Employee ↔ Department**: Many-to-Many
- **Employee ↔ Address**: One-to-Many

## ✅ How to Run

1. Clone the repository:

``bash
git clone https://github.com/suyash7318/EmployeeManagement.git
cd EmployeeManagement


Open the project in your IDE (e.g., VS Code, IntelliJ).

Run the application using Maven:

mvn spring-boot:run
Or you can run EmployeeManagementSystemApplication.java directly.

Access the APIs at:

http://localhost:8089/

📬 Contact
Suyash Santosh Tambade
🔗 LinkedIn
📧 suyash7318@gmail.com
