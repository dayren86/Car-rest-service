FROM adoptopenjdk:11-jre-hotspot
RUN mkdir -p -v /src/main/resources/
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} car-0.0.1-SNAPSHOT.jar
COPY file.csv /src/main/resources/file.csv
ENTRYPOINT ["java","-jar","car-0.0.1-SNAPSHOT.jar"]