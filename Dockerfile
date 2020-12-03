FROM openjdk/openjdk-11
COPY build/libs/server.jar /server.jar
ENTRYPOINT ["java", "-jar", "/server.jar"]