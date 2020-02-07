FROM openjdk:11-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} rabbitmq-producer.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "rabbitmq-producer.jar"]
