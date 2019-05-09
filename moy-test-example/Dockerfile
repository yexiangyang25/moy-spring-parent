FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./target/moy-test-example-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xmx64m","-Xms64m","-jar","/app.jar"]