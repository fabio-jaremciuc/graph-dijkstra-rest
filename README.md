# Dijkstra Algorithm for Vacancy Matching
## Description
A recruiter needs to review applications received for job openings. Given the sheer volume of applications in some vacancies, looking one by one would be a very time consuming job.
The API aims to help the recruiter by indicating the most adherent people for each job.

## API Specifications
* **Level of professional experience:**

  * **1** Internship
  * **2** Entry Level
  * **3** Middle Level
  * **4** Senior
  * **5** Specialist
* **Location:** the nodes are represented by letters of the alphabet. Below the map with the distances between the nodes.

* **Candidate Score:** Each candidate should receive a score for each application they make. This score is defined based on the level of experience and location in relation to the position you applied for.

* **Candidate Score:** Each candidate should receive a score for each application they make. This score is defined based on the level of experience and location in relation to the position you applied for.

candidate score calculation formula

<a href="https://camo.githubusercontent.com/7512337ea198e0d84ddd2cd43de512ba52129f06/687474703a2f2f6c617465782e636f6465636f67732e636f6d2f6769662e6c617465783f53434f524525323025334425323025354364667261632537424e2532302b2532304425374425374232253744" target="_blank"><img src="https://camo.githubusercontent.com/7512337ea198e0d84ddd2cd43de512ba52129f06/687474703a2f2f6c617465782e636f6465636f67732e636f6d2f6769662e6c617465783f53434f524525323025334425323025354364667261632537424e2532302b2532304425374425374232253744" title="score = (N + D)/2" /></a>

N is defined by:

<a href="https://www.codecogs.com/eqnedit.php?latex=N&space;=&space;100&space;-25&space;*&space;(JL&space;-&space;JC)" target="_blank"><img src="https://latex.codecogs.com/gif.latex?N&space;=&space;100&space;-25&space;*&space;(JL&space;-&space;JC)" title="N = 100 -25 * (JL - JC)" /></a>

Where:
* JL is the expected level of experience for the job
* JC is the candidate's experience level

To set the value of D, find the shortest distance between the candidate and the vacancy and use this value to refer to the following table:

**Shortest distance between applicant and vacancy** | **D**
-------------------------------------------------- | -------------
0 to 6 | 100
greater than 6.0 up to 8.75 | 75
greater than 8.75 up to 13.75 | 50
greater than 13.75 up to 18.75 | 25
greater than 18.75 up to 20 | 0

**API Endpoints**

Request to register job openings:

`POST http://localhost:8080/graph/v1/vacancy`

* Body:

Response:

Request to register candidates:

`POST http://localhost:8080/graph/v1/candidate`

* Body:

Response:

Request to applying for a vacancy:

`POST http://localhost:8080/graph/v1/application`

* Body:

Response:

Request to return candidates for a vacancy, sorted by score (descending):

`GET http://localhost:8080/graph/v1/application/ranking`

Response:

## Deployment
`TBD`

## Built With
* [Spring Boot](https://spring.io/projects/spring-boot) - The framework used
* [Docker](https://www.docker.com/) and [Docker Compose](https://docs.docker.com/compose/) - The container software and container orchestrator used
* [MySQL](https://www.mysql.com/) - The Database Management System used
* [H2](https://www.h2database.com/html/main.html) - The in-memory database used for the tests
* [MyBatis](https://mybatis.org/mybatis-3/) - The persistence framework used
* [SpringFox](https://springfox.github.io/springfox/) - The framework used to build the [Swagger](https://swagger.io/) documentation in Java Runtime

## Author
* [Fabio Jaremciuc](https://www.linkedin.com/in/fabio-jaremciuc-5b508343/)  - Initial work 

## License
This project is licensed under the [MIT License](https://en.wikipedia.org/wiki/MIT_License)
