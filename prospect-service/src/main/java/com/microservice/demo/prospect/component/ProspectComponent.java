package com.microservice.demo.prospect.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.demo.prospect.entity.Prospect;
import com.microservice.demo.prospect.repository.ProspectRepository;

@Component
public class ProspectComponent {
	
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
	public Prospect getProspectById(long id){
		return prospectRepository.findOne(id);
	}
	
	/**
	 * Save a prospect to a persistent store
	 * @param prospect - the prospect to be saved
	 * @return The prospect saved with his identifier filled
	 */
	public Prospect save(Prospect prospect){
		return prospectRepository.save(prospect);
	}
	
}
