## Ad Hoc Transactions in Web Applications: The Good, the Bad, and the Ugly
# Research Architecture
**Background and Motivation:** This section introduces database transactions and ad hoc transactions in web applications, explaining why developers manage concurrent operations through locking primitives or validation in the application code rather than relying on standard database transactions.

**Study Subjects:** The paper selects eight popular open-source web applications as the research subjects, covering various fields such as e-commerce, social networks, project management, and more.

**Characteristics of Ad Hoc Transactions:** Through analyzing 91 cases of ad hoc transactions, the study explores how these transactions are designed, including the use of locks, validation mechanisms, and the scope of coordinated operations. This section delves into the flexibility and complexity of ad hoc transactions.

**Correctness Issues:** The paper studies the error-prone nature of ad hoc transactions, finding that many of them are susceptible to issues, particularly in the use of locks and the atomicity of validation and commit processes. This section investigates the various causes of incorrect ad hoc transactions.

**Performance Evaluation:** By comparing the performance of ad hoc transactions and traditional database transactions, the paper demonstrates how ad hoc transactions can improve system performance in certain high-contention scenarios through finer-grained control, such as column-level locking.

**Discussion and Implications:** Based on the findings, this section discusses the potential impact of ad hoc transactions on database systems and web application development, and suggests directions for future research.

# Key Concepts
Database Transactions: Refers to a database management technique that ensures data operations follow the ACID properties (Atomicity, Consistency, Isolation, Durability).

Ad Hoc Transactions: Database operations managed explicitly by developers in the application code rather than relying on the database’s transaction management system.

Concurrency Control: Techniques and methods used to ensure data correctness and consistency in a multi-user environment.

Performance Evaluation: The analysis of how ad hoc transactions perform in high-contention environments and how their performance compares with traditional database transactions.

Error-proneness: Due to the flexibility and complexity of ad hoc transactions, they are more susceptible to errors, which can affect data consistency and system stability.

# Simplified Process of This Paper
1. Select Study Applications:
Choose a few of the open-source web applications mentioned in the paper (e.g., Broadleaf, Mastodon, Discourse).
Download the source code and ensure they use the ORM frameworks described in the paper.

2. Identify Ad Hoc Transactions:
Search the code for ad hoc transactions, focusing on sections that use locking and concurrency control mechanisms. Use keywords like "lock" and "concurrency" to help locate them.
Verify the concurrency control mechanisms in these transactions, such as the use of locks or validation procedures.

3. Test for Concurrency Errors:
Create simple concurrent scenarios to test these ad hoc transactions and attempt to trigger the errors mentioned in the paper (e.g., deadlocks or data inconsistency).
Focus on testing the transactions the paper identifies as problematic to see if they reproduce similar issues.

4. Performance Testing:
Use load testing tools (like Apache JMeter or Locust) to simulate high-concurrency user requests and compare the performance of ad hoc transactions with traditional database transactions for key APIs.
Measure the response time and throughput under load.

5. Replicate Results:
Compare the performance improvements reported in the paper (e.g., the performance benefits of ad hoc transactions under high contention), and validate throughput and latency data.