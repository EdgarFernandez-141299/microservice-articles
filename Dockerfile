

FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn

COPY mvnw pom.xml ./

RUN apt-get update && apt-get install -y dos2unix

RUN dos2unix ./mvnw

RUN ./mvnw dependency:resolve

copy src ./src

CMD ["*./mvnw", "spring-boot:run"]
