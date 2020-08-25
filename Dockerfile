FROM openjdk:8-jre
VOLUME /tmp
ADD ./base-component-organization-web/base-component-organization.jar base-component-organization.jar
RUN bash -c 'touch /base-component-organization.jar'
EXPOSE 40005
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=128m -Xms768m -Xmx768m","-jar","/base-component-organization.jar"]