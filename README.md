# Assignment: Master Customer

RESTful webservice using Spring Boot and JPA/Hibernate to save and retrieve a customer in a relational in memory database H2. A customer can have multiple addresses of type Billing or shipping. A customer should have first and last name and the address should have fields of a USA address.

## Minimum requirements 
To build and run the application you only need a JDK 8 available.

## Useful tips

Default HTTP port: 8080

Basic Authentication credentials:

```java
User: admin
Pass: admin
```

Default H2 console URL

```java
http://localhost:8000/mc/h2-console
```

Default Swagger URL

```java
http://localhost:8000/mc/swagger-ui.html
```


## Project structure
- mc-master-customer-parent: Parent project defining all dependency versions.
- mc-master-customer-repository: JPA entities and Spring Data repositories to access H2 database
- mc-master-customer-services: Business logic, application model and exceptions model 
- mc-master-customer-starter: Spring Boot application
- mc-master-customer-web: Controllers, basic authentication configuration, http logging configuration, swagger configuration


## Compile and Run
To build the application you must clone the project from the GIT repository to your local machine.

```bash
# Clone repository
git clone https://github.com/baleado/mc-master-customer.git

# Navigate inside directory
cd mc-master-customer/mc-master-customer-parent

```

You can compile the application by runnning mvnw
```bash
mvnw clean install
```

When compilation is complete you should be able to run the application with the following command
```java
cd mc-master-customer-starter/target
java -jar mc-master-customer-starter-0.0.1-SNAPSHOT.jar
```

After application started you should be able to access the swagger through the following URL:

```java
http://localhost:8000/mc/swagger-ui.html
```

Note: Application is secured with a very simple basic authentication. To authenticate use the following credentials:
```java
User: admin
Pass: admin
```

## Testing

Access swagger-ui to invoke the endpoints available to manage customers and their addresses.

```java
http://localhost:8000/mc/swagger-ui.html
```

Have fun!