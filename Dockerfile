FROM openjdk:17-jdk-slim

WORKDIR /app
COPY . /app
RUN ./mvnw clean install


COPY target/everyonesblogs-0.0.1-SNAPSHOT.jar ericksblog.jar

EXPOSE 3000

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "ericksblog.jar"]
