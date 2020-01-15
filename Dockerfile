FROM openjdk:8-jre-alpine
COPY ImportandUrgent-1.0.jar /ToDoList.jar
CMD ["/usr/bin/java", "-jar", "ToDoList.jar"]
