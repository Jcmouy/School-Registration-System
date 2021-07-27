#OBJECTIVE

Project 1: School registration system

Design and implement simple school registration system
- Assuming you already have a list of students
- Assuming you already have a list of courses
- A student can register to multiple courses
- A course can have multiple students enrolled in it.
- A course has 50 students maximum
- A student can register to 5 course maximum

Provide the following API:
- Create students CRUD
- Create courses CRUD
- Create API for students to register to courses
- Create Report API for admin user to view all relationships between students and courses
+ Filter all students with a specific course
+ Filter all courses for a specific student
+ Filter all courses without any students
+ Filter all students without any courses

#TECHNOLOGY STACK
* Spring Boot
* Maven
* Mysql 
* Docker Compose

#ENDPOINTS

- SWAGGER: 
+ http://localhost:8080/api/swagger-ui/index.html
+ http://localhost:8080/api/v2/api-docs


- Additional endpoints:
+ http://localhost:8080/api/actuator


#PROJECT SETUP

##ENVIRONMENT VARIABLES

You need to define an environment variable with the mysql host.

* Example: MYSQL_HOST = localhost

#COMPILATION INSTRUCTIONS

Execute "maven clean install" and the jar will be generated on the target folder.
