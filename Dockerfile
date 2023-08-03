FROM amazoncorretto:18-alpine as corretto-jdk-18

COPY ./target/imcCalculator-0.0.1-SNAPSHOT.jar /app/app.jar
RUN mkdir /app/unpacked && \
cd /app/unpacked && \
unzip ../app.jar && \
cd .. && \
$JAVA_HOME/bin/jdeps \
--ignore-missing-deps \
--print-module-deps \
-q \
--recursive \
--multi-release 17 \
--class-path="./unpacked/BOOT-INF/lib/*" \
--module-path="./unpacked/BOOT-INF/lib/*" \
./app.jar > /deps.info

FROM amazoncorretto:17.0.3-alpine as corretto-jdk-17

RUN apk add --no-cache binutils

COPY --from=corretto-jdk-18 /deps.info /deps.info

RUN $JAVA_HOME/bin/jlink \
--verbose \
--add-modules $(cat /deps.info) \
--strip-debug \
--no-man-pages \
--no-header-files \
--compress=2 \
--output /jre-minimal

FROM alpine:latest
ENV JAVA_HOME=/jre
ENV PATH="${JAVA_HOME}/bin:${PATH}"

COPY --from=corretto-jdk-17 /jre-minimal $JAVA_HOME

RUN mkdir /app
COPY ./target/imcCalculator-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app

EXPOSE 8081
ENTRYPOINT [ "/jre/bin/java", "-jar", "/app/app.jar" ]