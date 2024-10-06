
FROM eclipse-temurin:21.0.3_9-jdk-alpine as openjdk-21

RUN apk add --no-cache binutils

RUN $JAVA_HOME/bin/jlink \
         --verbose \
         --add-modules ALL-MODULE-PATH \
         --strip-debug \
         --no-man-pages \
         --no-header-files \
         --compress=2 \
         --output /jreoptimized

FROM alpine:latest
ENV JAVA_HOME=/jre
ENV PATH="${JAVA_HOME}/bin:${PATH}"


COPY --from=openjdk-21 /jreoptimized $JAVA_HOME

ENV TZ=America/Mexico_City


COPY ./target/microservice-articles-0.0.1-SNAPSHOT.jar /app/

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["/jre/bin/java","-jar","microservice-articles-0.0.1-SNAPSHOT.jar"]