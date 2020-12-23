FROM openjdk:8
ADD target/commerce-0.0.1-SNAPSHOT.jar commerce-0.0.1-SNAPSHOT.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","commerce-0.0.1-SNAPSHOT.jar"]

