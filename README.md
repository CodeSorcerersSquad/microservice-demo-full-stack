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
- [ELK - Elastic Search, Logstash & Kibana]


## Building & Configuration

### Config Dopcker
- Install Docker
-- https://docs.docker.com/engine/installation/linux/ubuntu/

- Install Docker Componse
-- https://docs.docker.com/compose/install/


### Config Kafka
TODO



### Config ELK
TODO

Installation
cd elk
$ sudo docker build -t elk:1.0 .

Specific version combinations of Elasticsearch, Logstash and Kibana can be pulled by using tags.

For instance, the image containing Elasticsearch 1.7.3, Logstash 1.5.5, and Kibana 4.1.2 (which is the last image using the Elasticsearch 1.x and Logstash 1.x branches) bears the tag E1L1K4, and can therefore be pulled using sudo docker pull sebp/elk:E1L1K4.

The available tags are listed on Docker Hub's sebp/elk image page or GitHub repository page.

By default, if no tag is indicated (or if using the tag latest), the latest version of the image will be pulled.


Usage
Run a container from the image with the following command:

$ sudo docker run -p 5601:5601 -p 9200:9200 -p 4560:4560 -it --name elk elk:1.0

Note – The whole ELK stack will be started. See the Starting services selectively section to selectively start part of the stack.

This command publishes the following ports, which are needed for proper operation of the ELK stack:

    5601 (Kibana web interface).
    9200 (Elasticsearch JSON interface).
    5044 (Logstash Beats interface, receives logs from Beats such as Filebeat – see the Forwarding logs with Filebeat section).

Note – The image also exposes Elasticsearch's transport interface on port 9300. Use the -p 9300:9300 option with the docker command above to publish it. This transport interface is notably used by Elasticsearch's Java client API, and to run Elasticsearch in a cluster.

https://elk-docker.readthedocs.io/

obs. In case of this error: max virtual memory areas vm.max_map_count [65530] is too low
$ sudo sysctl -w vm.max_map_count=262144

### Config Spring Boot Applications
mvn clean install

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



