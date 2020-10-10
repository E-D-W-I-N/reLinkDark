FROM openjdk:15-jdk-alpine
COPY ./target/relink.jar /app/
CMD ["java", "-jar", "/app/relink.jar"]
EXPOSE 8080