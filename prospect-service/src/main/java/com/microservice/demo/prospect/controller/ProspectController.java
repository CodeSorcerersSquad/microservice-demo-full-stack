package com.microservice.demo.prospect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.demo.prospect.component.ProspectComponent;
import com.microservice.demo.prospect.entity.Prospect;

@RestController
@RequestMapping("/prospect-service/v1")
public class ProspectController {
	
	@Autowired
	private ProspectComponent prospectComponent;
	
	@RequestMapping("/prospects")
	public List<Prospect> getAllProspect(){
		return prospectComponent.getAllProspects();
	}
	
	@RequestMapping("/prospects/{id}")
	public Prospect getProspectById(@PathVariable long id){
		return prospectComponent.getProspectById(id);
	}
	
	
}
