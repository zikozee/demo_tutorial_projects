FROM openjdk:11

VOLUME /tmp

EXPOSE 60000

ARG JAR_FILE=target/*.jar

COPY $JAR_FILE app.jar

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom \
 -Dspring.profiles.active=$SPRING_PROFILE \
 -jar app.jar
