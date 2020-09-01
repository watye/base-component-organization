FROM registry.talelife.com/library/java:v1.8
VOLUME /tmp
ADD ./base-component-organization-web/target/base-component-organization.jar /base-component-organization.jar
EXPOSE 40005
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/base-component-organization.jar"]