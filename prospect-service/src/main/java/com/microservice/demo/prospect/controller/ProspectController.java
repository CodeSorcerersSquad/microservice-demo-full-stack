package com.microservice.demo.prospect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.demo.prospect.component.ProspectComponent;
import com.microservice.demo.prospect.entity.Prospect;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="prospect-api", produces="application/json")
@RestController
@RequestMapping("/prospect-service/v1")
public class ProspectController {
	
	@Autowired
	private ProspectComponent prospectComponent;
	
	@ApiOperation(value = "Get all prospects", notes = "Return all prospects", produces = "application/json", consumes = "application/json")
	@RequestMapping("/prospects")
	public List<Prospect> getAllProspect(){
		return prospectComponent.getAllProspects();
	}
	
	@ApiOperation(value = "Get a prospect by id", notes = "Return a prospect by id", produces = "application/json", consumes = "application/json")
	@RequestMapping("/prospects/{id}")
	public Prospect getProspectById(
			@ApiParam(value = "1", required = true)
			@PathVariable long id){
		return prospectComponent.getProspectById(id);
	}
	
	@RequestMapping(value = "/prospects", method = RequestMethod.POST)
	@ApiOperation(value = "Post a new prospect", notes = "Create a new post", produces = "application/json", consumes = "application/json")
	public Prospect saveProspect(
			@RequestBody Prospect prospect){
		return prospectComponent.save(prospect);
	}
	
}
