# Demonstration of Microservices Full Stack
This goal of this project is to illustrate a full stack demonstration of a microservice architecture in practice.

## Project

- Propspect
	- Spring Boot
	- Docker Image
- Avaliation
	- TBD
- Client
	- TBD

- Gateway
	- Zuul

- Discovery Service
	- Eureka
- Apache Mesos & Marathon
- 

RAML to document the APIs

-- Documentation of the code --> 

*******Under Construction*******

## Requirements
- [Java 1.8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org/)
- [Docker](https://docs.docker.com/engine/installation/)
- [Docker Compose](https://docs.docker.com/compose/install/)


## Building & Configuration


### Config / Run Kafka
```bash
docker run -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=localhost --env ADVERTISED_PORT=9092 --env AUTO.CREATE.TOPICS.ENABLE=true spotify/kafka
```

### Config ELK
Installation
Start the ELK stack using *docker-compose*:

```bash
$ docker-compose up
```

You can also choose to run it in background (detached mode):

```bash
$ docker-compose up -d
```

Usage

Now that the stack is running, you'll want to inject logs in it. The shipped logstash configuration allows you to send content via tcp:

```bash
$ nc localhost 5000 < /path/to/logfile.log
```

And then access Kibana UI by hitting [http://localhost:5601](http://localhost:5601) with a web browser.

*NOTE*: You'll need to inject data into logstash before being able to configure a logstash index pattern in Kibana. Then all you should have to do is to hit the create button.

Refer to [Connect Kibana with Elasticsearch](https://www.elastic.co/guide/en/kibana/current/connect-to-elasticsearch.html) for detailed instructions about the index pattern configuration.

By default, the stack exposes the following ports:
* 5000: Logstash TCP input.
* 9200: Elasticsearch HTTP
* 5601: Kibana

[Reference Project](https://github.com/deviantony/docker-elk)

obs. In case of this error: max virtual memory areas vm.max_map_count [65530] is too low
$ sudo sysctl -w vm.max_map_count=262144

### Build Spring Boot Applications
***Eureka Server
```bash
cd eureka-server
mvn clean install
docker build -t eureka-server:1.0.0 .
docker run --net host -p 8090:8090 -t eureka-server:1.0.0
```

Build Docker Images --> TODO

Configure Apache Mesos and Marathon --> TODO

*******Under Construction*******

## Deploying
*******Under Construction*******

## Running

Test the api --> TODO

Check the elastic dashboard  --> TODO

Scaling  --> TODO

## Conclusion
*******Under Construction*******



