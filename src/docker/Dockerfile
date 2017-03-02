FROM java:8
VOLUME /tmp
ADD ad_micro_service-0.0.1-SNAPSHOT.jar ad_micro_service.jar
EXPOSE 8093
RUN sh -c 'touch /ad_micro_service.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /ad_micro_service.jar" ]
