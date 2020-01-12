FROM maven:3.6.0-jdk-8-alpine
COPY . /graph-dijkstra-rest/
VOLUME /config
WORKDIR /graph-dijkstra-rest/
RUN mvn package
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/graph-dijkstra-rest/target/graph-dijkstra-rest-0.0.1-SNAPSHOT.jar"]