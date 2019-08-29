FROM java:8
EXPOSE 8761

VOLUME /tmp
ADD microservice-discovery-eureka-0.0.1-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
