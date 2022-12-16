FROM openjdk:17-oracle

COPY . /api
WORKDIR /api

RUN ./mvnw package

ENTRYPOINT ["java","-jar","target/TodoAPI-0.0.1-SNAPSHOT.jar"]