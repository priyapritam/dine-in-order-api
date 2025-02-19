# Dine-In-Order API 🍽️

## Overview
Dine-In-Order API is a feature-rich RESTful API designed to streamline restaurant operations by managing tables, QR-based ordering, real-time order tracking, and automated billing. Built with **Spring Boot, Hibernate (JPA), and MySQL**, this API ensures an efficient and seamless dining experience.


## Features 🚀
- **User Management:** Admin and staff authentication & role-based access.
- **Restaurant & Table Management:** Manage restaurant details, tables, and seating.
- **QR Code Integration:** Generate QR codes for tables to facilitate ordering.
- **Food Menu:** CRUD operations for food items and categories.
- **Order Processing:** Add items to cart, place orders, track order status.
- **Billing System:** Generate bills, calculate totals, and manage payments.
- **Real-time Status Updates:** Track order and table availability in real-time.


## Tech Stack 🛠️
- **Backend:** Java, Spring Boot, Hibernate (JPA)
- **Database:** MySQL
- **API Documentation:** Swagger
- **Security:** JWT Authentication, Spring Security
- **Build Tool:** Maven
- **Server Deployment:** Apache Tomcat


## Entity Relationship Diagram (ERD) 🏗️
The API follows a well-structured ERD to manage restaurant entities efficiently:

- **User (Admin, Staff)**
- **Restaurant**
- **Table**
- **QR Code**
- **Food Item & Category**
- **Cart Items**
- **Orders**
- **Bill**

![Image](https://github.com/user-attachments/assets/687c0430-dd8d-44d0-8e1a-c0aa4a44e47d "Dine-In-Order.drawio")


## API Endpoints 🌐
### User Management
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/api/auth/register` | Register a new user |
| `POST` | `/api/auth/login` | Authenticate and generate JWT token |

### Restaurant & Table Management
| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET` | `/api/restaurants` | Get all restaurants |
| `POST` | `/api/restaurants` | Add a new restaurant |
| `GET` | `/api/tables/{restaurantId}` | Get tables by restaurant |

### Orders & Billing
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/api/orders` | Place an order |
| `GET` | `/api/orders/{orderId}` | Get order details |
| `POST` | `/api/bills` | Generate a bill |


## Installation & Setup 🏗️
### Prerequisites
- Java 17+
- MySQL Database
- Apache Tomcat
- Maven

### Steps to Run
1. **Clone the repository:**
   ```sh
   git clone https://github.com/priyapritam/dine-in-order-api.git
   cd dine-in-order-api
   ```
2. **Configure MySQL Database:**
   Update `application.properties` with database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/dineinorderdb
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```
3. **Build the project:**
   ```sh
   mvn clean install
   ```
4. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```
5. **Access API Documentation:**
   Open [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/) in your browser.


## Contributing 🤝
Contributions are welcome! Follow these steps to contribute:
1. Fork the repository.
2. Create a new branch: `git checkout -b feature-branch`
3. Commit changes: `git commit -m 'Add new feature'`
4. Push to your branch: `git push origin feature-branch`
5. Submit a pull request.


## Contact 📧
For queries or contributions, reach out via:
- **Email:** [priyapritam.pritam@gmail.com](mailto:priyapritam.pritam@gmail.com)
- **LinkedIn:** [linkedin.com/in/priyapritam](https://linkedin.com/in/priyapritam)


⭐ If you like this project, give it a star on [GitHub](https://github.com/priyapritam/dine-in-order-api)!
