FROM openjdk:latest
RUN mkdir Project
COPY target/LabProject-0.0.1-SNAPSHOT.jar Project/
RUN chmod +x Project/LabProject-0.0.1-SNAPSHOT.jar
CMD java -jar Project/LabProject-0.0.1-SNAPSHOT.jar
