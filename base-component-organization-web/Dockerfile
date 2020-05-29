FROM openjdk:8-jre
VOLUME /tmp
ADD component-org-web.jar component-org-web.jar
RUN bash -c 'touch /component-org-web.jar'
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=128m -Xms768m","-Xmx768m","-jar","/component-org-web.jar"]