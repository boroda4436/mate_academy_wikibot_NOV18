FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} youtube-jv-nov18.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/youtube-jv-nov18.jar"]
