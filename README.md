Task Management System
A REST API for managing daily tasks with authentication, built with Spring Boot and Oracle Database.
Features

User Authentication: JWT-based login and registration
Task Management: Create, update, delete, and track tasks
Sub-Tasks: Break down tasks into smaller actionable items
Date-Based Planning: Schedule and retrieve tasks by date
Priority & Points System: Prioritize tasks and earn points on completion
Time Tracking: Set planned and actual start/end times
Bilingual Support: English and Arabic error messages
API Documentation: Interactive Swagger UI

Tech Stack

Spring Boot 3.2.0
Java 17
Oracle Database
Spring Security + JWT
MapStruct
Maven

Quick Start
Prerequisites

JDK 17+
Oracle Database
Maven

Setup

Configure Database (application.yml):

yamlspring:
  datasource:
    url: jdbc:oracle:thin:@//localhost:1521/orclpdb
    username: hr
    password: hr

Run Application:

bash./mvnw spring-boot:run
Application starts at: http://localhost:8642
API Endpoints
Authentication (Public)

POST /auth/create-account - Register new user
POST /auth/login - Login and get JWT token

Tasks (Authenticated)

POST /task/add - Create task
POST /task/add-big-task - Create task with sub-tasks
POST /task/update - Update task
DELETE /task/delete - Delete task
GET /task/get-task/date/{date} - Get tasks by date
GET /task/points - Get today's points

Sub-Tasks (Authenticated)

POST /sub-task/update - Update sub-task
DELETE /sub-task/delete - Delete sub-task

Usage Example
1. Create Account
jsonPOST /auth/create-account
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123"
}
2. Login
jsonPOST /auth/login
{
  "email": "john@example.com",
  "password": "password123"
}
Response: { "token": "eyJhbGc...", "roles": ["ROLE_USER"] }
3. Create Task (use token in header)
jsonPOST /task/add
Authorization: Bearer eyJhbGc...

{
  "name": "Complete documentation",
  "description": "Write README file",
  "day": "2025-01-15",
  "priority": "HIGH",
  "startTime": "09:00:00",
  "endTime": "11:00:00",
  "points": 50,
  "type": "WORK"
}
API Documentation
Visit Swagger UI: http://localhost:8642/swagger-ui.html
Security

JWT authentication with 5-day expiration
BCrypt password encryption
Role-based access control (RBAC)
CORS enabled for http://localhost:8642

Configuration
Key settings in application.yml:

Server Port: 8642
JWT Secret: Change in production!
Token Expiration: 5 days
Database: Oracle (hr/hr)

License
Apache License 2.0