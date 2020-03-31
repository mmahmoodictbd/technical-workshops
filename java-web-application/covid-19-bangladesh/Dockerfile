FROM adoptopenjdk/openjdk11-openj9:alpine-jre
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} /app.jar
CMD ["java", "-jar", "/app.jar"]