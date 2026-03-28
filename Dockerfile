FROM openjdk:8
EXPOSE 9090
ADD target/swaggerdemo.jar swaggerdemo.jar
ENTRYPOINT ["java", "-jar", "/swaggerdemo.jar"]