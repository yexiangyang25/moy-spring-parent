FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./target/moy-test-example-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xmx128m","-Xms128m","-jar","/app.jar"]