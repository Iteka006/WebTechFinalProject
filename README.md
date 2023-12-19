# WebTechFinalProject
**Introduction**
The Online Bus Ticket Booking System aims to provide a convenient and efficient platform for users to book bus tickets from the comfort of their homes. This system simplifies the traditional process of purchasing bus tickets, offering users a seamless and user-friendly experience.

 **Project Requirements**
 1. _Purpose of the Project_
 The purpose of the Online Bus Ticket Booking System is to provide a platform for users to browse and book bus tickets. The system should facilitate bus registration, seat booking, user registration, and document upload/download for buses.
2. _Expected Outcomes:_
   User Registration and Authentication:
- Users should be able to register and log in securely.
- Differentiate between user roles (e.g., user and admin).
  
  Bus Management:
- Buses should be registerable with details such as bus number, origin, destination, date, etc.
- The system should support updating and deleting bus information.
  
  Seat Booking:
- Users should be able to search for available buses based on origin, destination, and date.
- Users should be able to select and book available seats on a chosen bus.
  
- Document Management:
Buses should support the upload and download of documents (Information about the Bus).

3. _Constraints or Limitations:_
Security: Ensure secure authentication and authorization mechanisms.
Performance: The system should handle concurrent user requests efficiently.
Scalability: The system should be scalable to accommodate potential growth.

**Project Plan**
Scope of the Project:

Phase 1: Basic Functionality

Implement user registration and authentication.
Implement bus registration and management.
Develop basic seat booking functionality.


Phase 2: Enhanced Functionality

Improve seat booking with additional features.
Implement document upload/download functionality.
Enhance user experience with a responsive front-end.

Phase 3: Optimization and Deployment

Optimize the system for performance and security.
Test the system extensively, fixing any bugs or issues.
Deploy the Project to GitHub.

Timeline:
Week 1: Phase 1 Development


User registration and authentication.
Bus registration and basic management.
Basic seat booking functionality.

Week 2:Phase 2 Development

Enhanced seat booking features.
Document upload/download functionality.
Front-end enhancements.

Week 3: Phase 3 - Optimization and Deployment


System optimization for performance.
Testing and bug fixing.
Deployment to GitHub.


Resources:


Spring Boot for Backend development.
Front-end (Cascading Style Sheets (CSS)).
Database (MySQL ).
Testing: PostMan. 



**DATABASE SCHEMA**

![ER_Diagram1](https://github.com/Iteka006/WebTechFinalProject/assets/85046852/2763c31a-6354-44cc-8fad-41d056ccbc1f)


 **User Documentation**
   
   1. Introduction <a name="introduction"></a>
Welcome to the Online Bus Ticket Booking System! This platform allows users to easily book bus tickets, search for available buses, and manage their bookings. This document will guide you through the various features of the application.

2. Login <a name="login"></a>
If you already have an account, use the login page to access your profile.

URL: (http://localhost:8080/login.html)
Credentials:
Username/Phone Number: [Your registered phone number]
Password: [Your chosen password]

3. Register: <a name="register"></a>
New users need to register to use the services. Follow these steps:

URL: (http://localhost:8080/register.html)
Provide your details: First Name, Last Name, Phone Number, Password and Confirm the Password. 
Click "Register."

4. Search Buses <a name="search-buses"></a>
URL: (http://localhost:8080/booking.html)
Enter the Origin, Destination, and Date.
Click "Search Buses" to see available options.

5. Book a Seat <a name="book-a-seat"></a>
After searching for buses, click on a specific bus to view available seats.
Select your preferred seat, enter passenger details, and click "Book."
Confirm your booking.

6. Download Document about Bus Information. 

7.  Logout <a name="logout"></a>
Click on "Logout" to securely log out of your account.


6. **Technical Documentation**
   Architecture
The Online Bus Ticket Booking System is a web-based application built on a microservices architecture. It consists of three main components:

Frontend: Designed using the Cascading Style Sheets (CSS)) for the user interface.
Backend: Built using the Spring Boot framework in Java. It handles business logic, communicates with the database, and exposes RESTful APIs.
Database: Utilizes  MySql  database management system to store and retrieve data.
The communication between the frontend and backend is facilitated through RESTful APIs, ensuring a decoupled and scalable system.

Implementation
Frontend
The frontend is designed to provide an intuitive and responsive user interface. It is designed using Cascading Style Sheets (CSS) for seamless user interactions. Key features include:

User authentication and authorization for secure access.
Dynamic rendering of bus information, seat selection, and booking functionalities.
Integration with backend APIs for data retrieval and updates.
Backend
The backend is developed using the Spring Boot framework in Java. Key components and features include:

Controllers: Handle incoming HTTP requests and interact with services.
Services: Contain business logic, process requests, and interact with the database.
Repositories: Communicate with the database using Spring Data JPA for data access.
Security: Implement authentication and authorization using Spring Security.
RESTful APIs: Expose endpoints for frontend communication.
Libraries and Frameworks
Backend:

[Spring Boot]
[Spring Data JPA]
[Spring Security]

Database: [Database Management System: MySQL]


Testing: [PostMan]
The application follows a comprehensive testing strategy, including unit tests for individual components, integration tests for interactions between components, and end-to-end tests to ensure the entire system functions correctly.


Conclusion
The Online Bus Ticket Booking System is designed and implemented with a focus on scalability, maintainability, and user experience. The chosen technologies and architectural patterns contribute to the robustness and efficiency of the application.

                                                                                                                                                    Author Grace Chanice Iteka 
