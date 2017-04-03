package com.microservice.demo.prospect.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.microservice.demo.prospect.entity.Prospect;

@Component
public class ProspectAvaliationComponent {
	
	@KafkaListener(id = "listen-prospect-aval", topics = "TOPIC.AVAL.PROSPECT", group = "group1")
	public void listenProspectAvaliation(final Prospect prospect) {
		System.out.println("Kafka Listen prospect: " + prospect);
		
	}
	
}
