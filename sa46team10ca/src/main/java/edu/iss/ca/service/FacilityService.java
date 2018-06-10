package edu.iss.ca.service;

import java.util.ArrayList;

import edu.iss.ca.models.Facility;

public interface FacilityService {

	ArrayList<Facility> findAllFacility();

	Facility findFacility(Integer id);

	Facility createFacility(Facility facName);

	Facility changeFacility(Facility facName);

	void removeFacility(Facility facName);
	
}
