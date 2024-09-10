# First stage (Build stage)
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Second stage (Run stage)
FROM openjdk:17
WORKDIR /app
COPY --from=build /build/target/Assignment-0.0.1-SNAPSHOT.jar Demo.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "Demo.jar"]
