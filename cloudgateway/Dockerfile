FROM maven:3.8.5-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM  openjdk:17

COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar

ENV APPLICATION_PORT=8080

ENV EUREKA_SERVICE_URL=http://eureka:8761/eureka
ENV KEYCLOAK_ISSUER_URL=http://keycloak:8080/auth/realms/spring-cloud-microservices

EXPOSE ${APPLICATION_PORT}

ENTRYPOINT ["java", "-Dserver.port=${APPLICATION_PORT}", \
    "-Dspring.security.oauth2.resourceserver.jwt.issuer-uri=${KEYCLOAK_ISSUER_URL}", \
    "-Deureka.client.serviceUrl.defaultZone=${EUREKA_SERVICE_URL}", "-jar","/usr/local/lib/app.jar"]

