FROM openjdk:11-jdk AS build
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN ./gradlew clean build --no-daemon

FROM openjdk:11-jdk
COPY --from=build /home/gradle/src/core/build/libs/core.jar /core.jar
ENTRYPOINT ["java", "-jar", "/core.jar"]