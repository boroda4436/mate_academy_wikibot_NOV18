FROM java:8
WORKDIR /
ADD target/youtube-jv-nov18.jar youtube-jv-nov18.jar
EXPOSE 8080
CMD ["java", "-jar", "youtube-jv-nov18.jar"]
