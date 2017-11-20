package com.microservice.demo.prospect.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.demo.prospect.entity.Prospect;
import com.microservice.demo.prospect.repository.ProspectRepository;

@Component
public class ProspectComponent {
	
	@Autowired
	private KafkaTemplate<String, Prospect> kafkaTemplate;
	
	@Autowired
	private ProspectRepository prospectRepository;
	
	/**
	 * Return all the prospects
	 * @return The list of all prospects
	 */
	public List<Prospect> getAllProspects(){
		return prospectRepository.findAll();
	}
	
	/**
	 * Return a specific prospect by id
	 * @param id - prospect identification
	 * @return The prospect idetified by its id
	 */
	public Prospect getProspectById(final long id){
		return prospectRepository.findOne(id);
	}
	
	/**
	 * Save a prospect to a persistent store
	 * @param prospect - the prospect to be saved
	 * @return The prospect saved with his identifier filled
	 */
	@Transactional
	public Prospect save(final Prospect prospect){
		
		Prospect prospectSaved = prospectRepository.save(prospect);
		kafkaTemplate.send("TOPIC.AVAL.PROSPECT", prospect);
		kafkaTemplate.flush();
		return prospectSaved;
	}
	
	
}
