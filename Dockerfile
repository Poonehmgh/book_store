FROM openjdk:17-jdk-slim as build
RUN apt-get update && apt-get install -y maven
WORKDIR /store
CMD ["mvn", "spring-boot:run"]
