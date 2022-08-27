FROM azul/zulu-openjdk-alpine:11-jre-headless
ENV JAVA_OPTS=""
ADD build/libs/*.jar /app/
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/*.jar" ]