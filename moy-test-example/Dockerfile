FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./target/moy-test-example-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xms128m","-Xmx128m","-jar","/app.jar"]