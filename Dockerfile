FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/ins-str-pms-resource-api-*.jar /ins-str-pms-resource-api.jar
ENTRYPOINT ["java","-jar","/ins-str-pms-resource-api.jar"]