# Bank Branch Service
Demo project on bank branch service.

# Getting Started

## Set-Up

### Requirements
1. JDK 11
2. Maven 3
3. Postgresql 10+

Clone project to local environment

Create a database in postgres and enter the databse url, username and password in src/main/resources/application.properties file i.e **spring.datasource.url=jdbc:postgresql://path to posgresSQL, spring.datasource.username=username, spring.datasource.password=password**

For data migration, enter banks.csv and bank_branches.csv file location in src/main/resources/application.properties file i.e **spring.liquibase.parameters.file.path.banks=file:///##path to file##/banks.csv, spring.liquibase.parameters.file.path.branches=file:///##path to file##/bank_branches.csv**

### Optional - Docker Image
You can build a docker image and push to a docker registry without installing the docker from the application using "jib-maven-plugin". For that you have to enter the docker registry url in pom.xml. If the registry is private enter the credientials in configuration.
```
<plugin> 
  <configuration> 
    <to>
				<image>############/demo:tortil-${project.version}</image>
    </to>
```

## Build and Test
To run the application using maven<br>
Build and run using: mvn spring-boot:run<br>
Test using: junit<br>

To build docker image using maven<br>
Build and push to registry: mvn compile jib:build

## API Document

You can access the API definiton using swagger.<br>
Go to URL: http://localhost:port/swagger-ui/#/

## Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#using-boot-devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
