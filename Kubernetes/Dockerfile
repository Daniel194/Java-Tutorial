FROM java:8
VOLUME /tmp
ADD build/libs/Kubernetes-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
