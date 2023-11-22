FROM openjdk:11
ARG JAR_FILE=*.jar
COPY build/libs/*.jar dockerservice.jar
ENTRYPOINT ["java","-jar","/dockerservice.jar"]