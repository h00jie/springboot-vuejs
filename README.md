# Springboot-vuejs 

> This project demonstrates on the use of Springboot to expose rest endpoints via @Restrepositoryresource for the backend
> and with Vue.js for the frontend

## Backend Build/Run Setup

``` bash
Create an empty database with name: springbootcrud

◦ Open the file: springbootcrud-webapp/src/main/resources/application.properties and
  modify the following properties, depending on your MySQL installation:
◦ spring.datasource.username=root
◦ spring.datasource.password=password

# Build project from the root folder
mvn clean install 

# Run project from springbootcrud-webapp
mvn spring-boot:run

```

#Backend Information

>Rest endpoints for Supplier & Person Entities

>localhost:8081/api/suppliers
>
>localhost:8081/api/persons

>#HAL Browser for Endpoint Documentation
>
>localhost:8081/api

## Frontend Build/Run Setup
``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report
```


Also i have implemented some tests for the Suppliers endpoints using JUnit & TestRestTemplate.