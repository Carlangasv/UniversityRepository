# University repository
## Personal project made by Carlos Valencia

Restful API to save data of a university

## Layers

- Models
- Repository
- Service
- Controller


The models are used to create the dataBase model and to define what fields has each type. 
The repository is the one that manipulates those objects, reading them from the database, creating and inserting or deleting them from the datasource.
On the service layer, the logic of how each object  interacts with the repository and is being exposed to the controller.
 On the controller layer , the endpoints got exposed, allowing us to use the API, using tools like Postman.

## Tech

Dillinger uses a number of open source projects to work properly:

- [Spring Boot] - Java framework used to create stand-alone spring based applications
- [Spring Security] -Spring Security is a powerful and highly customizable authentication and access-control framework
- [Spring Data JPA] - Part of the Spring Data family, used to access JPA based repositories
- [PostgreSQL] Open source object-relational database
- [JUnit 5] Library used to create test

## Available endpoints

The available endpoints are collected in a postman JSON

## License

MIT

**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [Spring Boot]: <https://spring.io/projects/spring-boot>
   [Spring Security]: <https://spring.io/projects/spring-security>
   [Spring Data JPA]: <https://spring.io/projects/spring-data-jpa>
   [PostgreSQL]: <https://www.postgresql.org/>
   [JUnit 5]: <https://junit.org/junit5/>

