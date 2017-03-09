package com.microservice.demo.prospect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservice.demo.prospect.entity.Prospect;

public interface ProspectRepository extends JpaRepository<Prospect, Long>{
	
	
	
}
