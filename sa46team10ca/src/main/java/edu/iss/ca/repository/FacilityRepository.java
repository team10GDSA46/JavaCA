package edu.iss.ca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.iss.ca.models.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer>{
	
}