FROM openjdk:17-jdk-alpine
EXPOSE 8081
ARG JAR_FILE=target/*.jar
COPY ./target/inter-interview-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]