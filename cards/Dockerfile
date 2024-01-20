FROM maven:3.8.5-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM  openjdk:17

COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar

ENV APPLICATION_PORT=8080

ENV RABBITMQ_HOST=rabbitmq
ENV RABBITMQ_PORT=5672
ENV RABBITMQ_USER=admin
ENV RABBITMQ_PASSWORD=admin

ENV EUREKA_SERVICE_URL=http://eureka:8761/eureka

EXPOSE ${APPLICATION_PORT}

ENTRYPOINT ["java", "-Dserver.port=${APPLICATION_PORT}", \
    "-Dspring.rabbitmq.host=${RABBITMQ_HOST}", "-Dspring.rabbitmq.port=${RABBITMQ_PORT}", \
    "-Dspring.rabbitmq.username=${RABBITMQ_USER}", "-Dspring.rabbitmq.password=${RABBITMQ_PASSWORD}", \
    "-Deureka.client.serviceUrl.defaultZone=${EUREKA_SERVICE_URL}", "-jar","/usr/local/lib/app.jar"]

