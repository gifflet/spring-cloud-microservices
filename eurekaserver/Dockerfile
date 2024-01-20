FROM maven:3.8.5-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM  openjdk:17

COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar

ENV APPLICATION_PORT=8761
ENV EUREKA_SERVICE_URL http://eureka:8761

EXPOSE ${APPLICATION_PORT}

ENTRYPOINT ["java", "-Dserver.port=${APPLICATION_PORT}", \
"-Deureka.client.serviceUrl.defaultZone=${EUREKA_SERVICE_URL}", "-jar","/usr/local/lib/app.jar"]

