#### To build Docker image
docker build -t todo-api .

#### To run Docker image
docker run -p 3000:8080 todo-api

#### To run Spring Boot using cmd
./mvnw spring-boot:run

#### To run jar file using cmd
java -jar target/TodoAPI-0.0.1-SNAPSHOT.jar