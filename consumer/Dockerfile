FROM openjdk:11-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} rabbitmq-consumer.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "rabbitmq-consumer.jar"]
