
FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  target/prospect-service-1.0.0.jar prospect-service.jar
EXPOSE 8070
ENTRYPOINT ["java","-jar","/prospect-service.jar"]


