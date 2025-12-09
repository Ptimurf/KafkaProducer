FROM alpine AS builder
COPY pom.xml /opt
COPY src /opt/src
RUN apk add openjdk21-jdk
RUN apk add maven
RUN ls /opt
RUN mvn -f /opt/pom.xml clean package

FROM alpine/java:21-jdk
WORKDIR /opt
COPY --from=builder /opt/target/*.jar ./producer.jar
ENTRYPOINT ["java", "-jar", "producer.jar"]