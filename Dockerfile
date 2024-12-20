FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/everyonesblogs-0.0.1-SNAPSHOT.jar ericksblog.jar
EXPOSE 4003
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar ericksblog.jar
