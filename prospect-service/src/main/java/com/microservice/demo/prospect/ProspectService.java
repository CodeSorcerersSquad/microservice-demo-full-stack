package com.microservice.demo.prospect;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.lang.reflect.WildcardType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicate;
import com.microservice.demo.prospect.entity.Address;
import com.microservice.demo.prospect.entity.Prospect;
import com.microservice.demo.prospect.repository.ProspectRepository;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.*;
import static springfox.documentation.schema.AlternateTypeRules.*;

/**
 * Startup the prospect service spring boot application. This class is
 * responsible to load some prospect to a H2 database.
 * 
 * @author rafael.manzoni
 *
 */
@SpringBootApplication
@EnableSwagger2
public class ProspectService implements CommandLineRunner {

	/**
	 * Log4J --> Interface
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProspectService.class);

	/**
	 * Prospect Repository to manipulate data into a persistent store
	 */
	@Autowired
	private ProspectRepository prospectRepository;
	
	@Autowired
	private TypeResolver typeResolver;
	
	/**
	 * Init a Spring Boot Application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProspectService.class, args);
	}

	/**
	 * Run this method when the spring boot prospect-service startup
	 */
	@Override
	public void run(String... strings) throws Exception {

		Address address = new Address(1233, "Av Paulista", "01527-098", "Ap 186", "Sao Paulo", "SP", "Brazil");
		Prospect prospect = new Prospect("Rafael Manzoni", "raf.man@gmail.com", address);

		Prospect result = prospectRepository.save(prospect);
		logger.info("checked in successfully ..." + result);

		logger.info("Looking to load prospect record...");
		logger.info("Result: " + prospectRepository.findOne(result.getId()));
		
		address = new Address(1211, "Av Brigadeiro Faria Lima", "01127-098", "Ap 12", "Sao Paulo", "SP", "Brazil");
		prospect = new Prospect("José da Silva", "jr.sil.21@gmail.com", address);

		result = prospectRepository.save(prospect);
		logger.info("checked in successfully ..." + result);

		logger.info("Looking to load prospect record...");
		logger.info("Result: " + prospectRepository.findOne(result.getId()));


	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("prospect-api")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.microservice.demo.prospect.controller"))
				.paths(paths())
				.build()
				.alternateTypeRules(
			            newRule(typeResolver.resolve(DeferredResult.class,
			                    typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
			                typeResolver.resolve(WildcardType.class)))
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfo());
	}
	
	private Predicate<String> paths() {
	    return or(
	        regex("/prospect.*"),
	        regex("/prospect-service.*"));
	  }
	
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Prospect REST API", 
				"REST API to manipulate and get prospect information", 
				"API TOS", 
				"Terms of service",
				"rmzoni@gmail.com", 
				"Apache License 2.0", 
				"https://github.com/rmzoni/microservice-demo-full-stack/blob/master/LICENSE");
		return apiInfo;
	}

}
