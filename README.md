
# Spring Boot Multi-Threading for Transaction Processing

This project demonstrates the use of multi-threading in Spring Boot to improve the performance of transaction processing when interacting with a MongoDB database. By leveraging parallel multi-threading, the project compares the efficiency of transaction processing between single-threaded and multi-threaded executions.

## Features

- **Multi-threaded Transaction Processing**: Utilizes `CompletableFuture` for parallel transaction execution.
- **MongoDB Integration**: A simple MongoDB setup to store product data.
- **Performance Comparison**: Measures and compares the execution time for single-threaded and multi-threaded transaction processing.

## Project Structure

The folder structure is as follows:

```
springboot-multithreading/
├── pom.xml                  # Maven build file
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/  # Application source code
│   │   │   ├── controller/         # Controllers for handling requests
│   │   │   ├── model/              # Product model for MongoDB
│   │   │   ├── repository/         # MongoDB repository for CRUD operations
│   │   │   ├── service/            # Service logic for transaction processing
│   │   ├── resources/
│   │   │   ├── application.properties  # MongoDB configuration
│   ├── test/
│   │   ├── java/com/example/demo/DemoApplicationTests.java  # Unit tests
```

**Note:** Make sure to rename the root folder to `demo` if it is not already named as such. The folder name should be `demo` to avoid any potential issues with the project structure.

## Prerequisites

Before running the project, ensure that you have the following installed:

- **Java 17+**: The project is built using Java 17. Make sure it's installed and set up in your environment.
- **MongoDB**: MongoDB should be running locally or you can use an external service.
- **Maven**: Maven is used as the build tool for this project.

## Running the Project

### 1. Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/sumanpitla/springboot-multithreading.git
cd springboot-multithreading
```

### 2. Rename the Project Folder (if necessary)

If your project folder is not named `demo`, rename it:

```bash
mv springboot-multithreading demo
cd demo
```

### 3. Configure MongoDB

Make sure MongoDB is up and running. You can use a local MongoDB instance or configure a remote MongoDB database.

In the `src/main/resources/application.properties` file, configure the MongoDB connection URL:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/your-database-name
```

### 4. Build the Project

To build the project using Maven, run the following command:

```bash
mvn clean install
```

### 5. Run the Project

To start the Spring Boot application, use the following command:

```bash
mvn spring-boot:run
```

The application will run on [http://localhost:8080](http://localhost:8080).

### 6. Test the Endpoints

Once the application is running, you can test the transaction processing endpoints:

- **Single-threaded transaction processing**: Visit the endpoint `/single-threaded` to execute transactions sequentially.
- **Multi-threaded transaction processing**: Visit the endpoint `/multi-threaded` to execute transactions concurrently using multi-threading.

Both endpoints will process a list of product IDs and measure the time taken for execution.

## Efficiency Comparison

This project demonstrates the efficiency difference between **single-threaded** and **multi-threaded** transaction processing:

- **Single-threaded execution** processes transactions one after another, which can be slow for large datasets.
- **Multi-threaded execution** leverages the power of multiple threads to execute transactions concurrently, significantly improving the execution time.

By using multi-threading, we are able to handle multiple product transactions simultaneously, leading to faster processing and improved system performance.

## Conclusion

By implementing multi-threading with `CompletableFuture` in Spring Boot, the project demonstrates a more efficient approach to handling large-scale transactions. The performance improvement is measurable and shows the clear advantage of parallel transaction processing over sequential execution.

---

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
