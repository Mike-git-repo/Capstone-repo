Enhancing Locking Mechanisms in Ad Hoc Transactions for Web Applications
Project Overview
This project focuses on improving the concurrency control of ad hoc transactions in web applications by implementing optimistic locking. Our work builds upon the paper "Ad Hoc Transactions in Web Applications: The Good, the Bad, and the Ugly", which identified key issues with traditional locking mechanisms, such as performance bottlenecks and error-proneness. By introducing optimistic locking, we aim to enhance transaction reliability, scalability, and correctness.

Key Features
Optimistic Locking: Allows multiple transactions to proceed concurrently without locking resources, checking for conflicts only at the commit stage.
Improved Performance: Reduces contention and deadlock possibilities in high-concurrency environments.
Atomicity and Version Control: Ensures that transaction consistency is maintained through version validation.
Technology Stack
Java: Main programming language for backend development.
Hibernate ORM: Used to manage the object-relational mapping and handle database operations.
MySQL: Database management system to persist transaction data.
Project Structure
