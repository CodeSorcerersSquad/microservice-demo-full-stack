FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  target/api-gateway-1.0.0.jar api-gateway.jar
EXPOSE 8075
ENTRYPOINT ["java","-jar","/api-gateway.jar"]


