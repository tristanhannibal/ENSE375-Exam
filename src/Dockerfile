FROM maven:3.6.3-jdk-11 AS build
MAINTAINER tristanhannibal
COPY pom.xml /usr/local/service/pom.xml
COPY src /usr/local/service/src
WORKDIR /usr/local/service
RUN mvn clean package
CMD java -cp target/ticket-1.0-SNAPSHOT.jar com.uregina.app.App