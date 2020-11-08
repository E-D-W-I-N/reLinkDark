FROM openjdk:15-jdk-alpine
COPY ./target/relinkdark.jar /reLinkDark/
CMD ["java", "-jar", "/reLinkDark/relinkdark.jar"]
EXPOSE 8080