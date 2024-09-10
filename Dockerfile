FROM openjdk:17

WORKDIR /app

COPY --from = build /target/Assignment-0.0.1-SNAPSHOT.jar Demo.jar

EXPOSE 8181

ENTRYPOINT ["java","-jar","demo.jar"]


