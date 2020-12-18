FROM openjdk:11
EXPOSE 80
ADD ./target/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java -Xmx1000m -Xms1000m -jar app.jar"]