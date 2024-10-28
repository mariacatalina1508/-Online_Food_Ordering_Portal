### Business Domain: Online Food Ordering Portal

**Description**

This is a service platform that allows customers to place orders from various restaurants. 
It focuses on managing meal combos and custom orders, offering a user-friendly interface for browsing menus, placing orders, and managing customer preferences.



**Tech Stack**

* Spring Boot: Backend framework for building the application.
* Java 17: Programming language used for development.
* Maven: Dependency management and build tool.
* PostgreSQL: Main database used for storing data persistently.
* H2 In-Memory Database: Used for integration and unit testing.
* MockMVC: Used for simulating HTTP requests in integration tests.
* JUnit: Framework for writing unit tests.
* Mockito: Library for mocking dependencies during unit testing.
* Hibernate: ORM (Object Relational Mapping) framework for interacting with the database.

**Core Functionalities**

* CRUD Operations: The application offers basic Create, Read, Update, and Delete (CRUD) operations for orders and menus.
* Custom Orders: Customers can create custom orders by choosing from various menu items.
* Filter-Based Queries: Advanced filtering is available to search for orders based on multiple parameters such as address, status, or date.
* Meal Combos: Management of predefined meal combos offered by restaurants.
* RESTful APIs: At least four RESTful API endpoints are implemented for performing CRUD operations, with one API supporting complex queries using multiple @RequestParam fields.

**How to Run the Application**

**Prerequisites:**

* Ensure you have Java 17 and Maven installed.
* PostgreSQL running (if using it for the database).

**Steps:**

1. Clone the repository: git clone https://github.com/mariacatalina1508/-Online_Food_Ordering_Portal.git
2. Navigate to the project directory: cd -Online_Food_Ordering_Portal
3. Build the project using Maven: mvn clean install
4. Run the application: mvn spring-boot:run


The application will start on 


**Access H2 Database (for testing): http://localhost:8080

* Visit http://localhost:8080/h2-console
* Use the default JDBC URL: `jdbc:h2:mem:testdb`

**Database Setup**

* **PostgreSQL:** Ensure PostgreSQL is installed and running. The application will automatically set up the required schema.
* **Alternatively:** You can populate the database using SQL scripts or through POST APIs for adding data.

**Testing**

* **Unit Tests:** Run the unit tests using JUnit and Mockito.
* **Integration Tests:** Integration tests are written using MockMVC to simulate requests and responses for various endpoints.

**Error Handling**

The application includes custom exception handling and validation mechanisms. 
Invalid input will result in meaningful error messages and appropriate HTTP status codes.
404 Not Found for missing resources (games, events, etc.).
400 Bad Request for invalid data input. Example Error Response (Game Not Found):

**Validation**

DTO and service-layer validations ensure that only valid data is persisted in the database. 
Errors are communicated back to the user with proper HTTP status codes.

**Project Structure**

src/
├── main/
│   ├── java/com/boardgamecafe
│   │   ├── controllers/        # REST Controllers
│   │   ├── exceptions/         # Exception handling
│   │   ├── models/             # DTOs and Entity classes
│   │   ├── repositories/       # Data Repositories
│   │   └── services/           # Service implementations
│   └── resources/
│       ├── application.properties  # Configuration
│       └── data.sql                # Optional data script
└── test/                           # Unit and integration tests