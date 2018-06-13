package edu.iss.ca.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.iss.ca.models.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer>{
	
}