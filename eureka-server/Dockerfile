
FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  target/eureka-server-1.0.0.jar eureka-server.jar
EXPOSE 9671
ENTRYPOINT ["java","-jar","/eureka-server.jar"]


