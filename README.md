"# service-management" 

1. Swagger file is available in root directory. /swagger_belong_coding_test.yaml

2. This is a spring boot project. To run this project: 
    1. Clone or download this project
    2. Import this project in in IDE
    3. Build this project with maven
    4. Run the project 
    5. Now below endpoints should be aviable in http://localhost:8080 

3. This project has following services:
    1. GET /serviceIds - To fetch all services in InMemory 
    2. GET /serviceIds/{customerId} - To fetch all services of a customer
    3. PUT /activateServiceId - To activate an available service number for a customer

4. Environment:
    1. Java8
    2. Spring 2.1.2
    3. maven 3.2.5

