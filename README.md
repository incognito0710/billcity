# Electricity Billing System

This is a Java-based desktop application for managing electricity billing operations. It uses Swing for the user interface and MySQL for data storage.

## Features
- Customer registration and management
- Bill calculation and generation
- Payment tracking
- Admin and user login
- Data visualization and reporting

## Prerequisites
- Java JDK 8 or above
- MySQL Server
- MySQL Connector/J (JDBC driver)
- IntelliJ IDEA or any Java IDE

## Setup Instructions
1. **Clone the repository:**
   ```
   git clone <your-repo-link>
   ```
2. **Import the project into your IDE.**
3. **Add MySQL JDBC Driver:**
   - Download `mysql-connector-java` from [MySQL Downloads](https://dev.mysql.com/downloads/connector/j/).
   - Add the JAR to your project's classpath.
4. **Configure MySQL Database:**
   - Create a database named `bill_system`.
   - Run the SQL scripts in the `setup/` folder to create required tables.
   - Update database credentials in your Java code if needed.
5. **Run the application:**
   - Execute the `main` method in the main class (e.g., `main_class.java`).

## Usage
- Use the GUI to register new customers, generate bills, and manage payments.
- Admins can view and update customer information.

## Troubleshooting
- Ensure MySQL server is running and accessible.
- Make sure the JDBC driver is added to the classpath.
- Check database credentials and table names in the code.

## License
This project is for educational purposes.

## Author
- Nkita Yadav

---
Feel free to contribute or raise issues via GitHub!

