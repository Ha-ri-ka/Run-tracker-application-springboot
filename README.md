**_An application that allows users to track their runs._**

There are 2 implementations for this: 
  1. with an in-memory database
  2. with a postgresql DB access through docker
     
The application contains a single microservice "run" that allows a user to enter the following details about their run:<br>
Id of the run<br>
title of the run <br>
started (date&time)<br>
ended (date&time)<br>
distance ran<br>
location (indoor or outdoor)

_Http requests for the microservice can be made for:_
  1. Obtain all runs data (GET)
  2. Obtain run data of a particular run ID (GET)
  3. Count number of instances in the databse (GET)
  4. Create a single new run (POST)
  5. Update an existing run using ID (PUT)
  6. Delete a run by ID (DELETE)

**project details:** <br>
Maven project<br>
java 17<br>
Springboot 3.3.0<br>
jar packaging<br>

_Dependencies used:_
1. spring-boot-starter-web
2. spring-boot-starter-validation
3. spring-boot-devtools
4. spring-boot-starter-test
5. spring-boot-starter-jdbc
6. spring-boot-docker-compose
7. postgresql

project made by following this tutorial --> https://youtu.be/31KTdfRH6nY?si=YIn2nvDm_xO9feyN
