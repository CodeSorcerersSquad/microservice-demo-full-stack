package com.microservice.demo.prospect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microservice.demo.prospect.entity.Address;
import com.microservice.demo.prospect.entity.Prospect;
import com.microservice.demo.prospect.repository.ProspectRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Startup the prospect service spring boot application.
 * This class is responsible to load some prospect to a H2 database.
 * @author rafael.manzoni
 *
 */
@SpringBootApplication
@EnableSwagger2
public class ProspectService implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(ProspectService.class);
	
	@Autowired
	private ProspectRepository prospectRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProspectService.class, args);
	}	
	
	@Override
	public void run(String... strings) throws Exception {
		
		Address address = new Address(1233, "Av Paulista", "01527-098", "Ap 186", "Sao Paulo", "SP", "Brazil");
		Prospect prospect = new Prospect("Rafael Manzoni", "raf.man@gmail.com", address);
		 
		Prospect result  = prospectRepository.save(prospect);
		logger.info("checked in successfully ..." + result);
		
		logger.info("Looking to load prospect record..."); 
	    logger.info("Result: " + prospectRepository.findOne(result.getId()));
 
	}
}
