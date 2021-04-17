FROM openjdk:11
ENV TZ 'Europe/Minsk'
EXPOSE 8081
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
CMD java $JVM_OPTS -jar ./app.jar