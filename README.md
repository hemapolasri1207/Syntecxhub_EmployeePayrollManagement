💼 Employee Payroll Management System (Java + JDBC + MySQL)

📌 Overview

This project is a console-based Employee Payroll Management System developed using Java and MySQL.
It allows users to manage employee salary details and perform full CRUD operations with accurate payroll calculations.

---

🛠️ Technologies Used

- Java (JDK 24)
- JDBC (MySQL Connector/J)
- MySQL Database
- Command Prompt

---

⚙️ Features

- ➕ Add Employee with salary details
- 📋 View Employee records
- ✏️ Update salary details
- 🧾 Generate Payslip
- 🗑️ Delete Employee
- 🔐 Secure database operations using PreparedStatement

---

🧮 Salary Calculation

Net Salary is calculated as:

Net Salary = Basic Salary + HRA + DA − Deductions

Where:

- Basic Salary = Base pay
- HRA = House Rent Allowance
- DA = Dearness Allowance
- Deductions = Taxes / PF / other cuts

---

🗄️ Database Setup

Run the following SQL in MySQL:

CREATE DATABASE payroll_db;
USE payroll_db;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    basic_salary DOUBLE,
    hra DOUBLE,
    da DOUBLE,
    deductions DOUBLE,
    net_salary DOUBLE
);

---

📂 Project Structure

PayrollProject/
│── DBConnection1.java
│── PayrollCRUD.java
│── MainApp1.java
│── mysql-connector-j-9.7.0.jar

---

▶️ How to Run

1. Compile the program:

javac -cp ".;mysql-connector-j-9.7.0.jar" *.java

2. Run the application:

java -cp ".;mysql-connector-j-9.7.0.jar" MainApp1

---

🔐 Configuration

Update database credentials in "DBConnection1.java":

"root", "your_password"

---

📸 Sample Output

===== Payroll System =====
1. Add Employee
2. View Employees
3. Update Salary
4. Generate Payslip
5. Delete Employee
6. Exit

---

📦 Dependency

Download MySQL Connector/J (JDBC Driver):
https://dev.mysql.com/downloads/connector/j/

---

👨‍💻 Author
Hema Polasri

Your Name
