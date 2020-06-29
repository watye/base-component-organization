FROM openjdk:8-jre
VOLUME /tmp
ADD base-base-component-organization-web.jar base-component-organization-web.jar
RUN bash -c 'touch /base-component-organization-web.jar'
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=128m -Xms768m -Xmx768m","-jar","/base-component-organization-web.jar"]