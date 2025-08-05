FROM eclipse-temurin:21-jre

LABEL maintainer="Julian"

ENV PARAMS=""
ENV SPRING_ARGS=""
ENV APP_LOG_PATH="--log.path=/data/logs/xxl-job/xxl-job-admin.log"

ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -pv /data/logs/xxl-job && \
    chmod 755 /data/logs/xxl-job

ADD target/xxl-job-admin-*.jar /app.jar

ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /app.jar $APP_LOG_PATH $PARAMS $SPRING_ARGS"]
