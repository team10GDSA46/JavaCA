package edu.iss.ca.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.ca.models.Facility;
import edu.iss.ca.repository.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Resource
	private FacilityRepository facilityRepository;
	
	@Override
	@Transactional
	public ArrayList<Facility> findAllFacility() {
		return (ArrayList<Facility>)facilityRepository.findAll();
	}

	@Override
	@Transactional
	public Facility findFacility(Integer id) {
		return facilityRepository.findOne(id);
	}

	@Override
	@Transactional
	public Facility createFacility(Facility facility) {
		return facilityRepository.saveAndFlush(facility);
	}

	@Override
	@Transactional
	public Facility changeFacility(Facility facility) {
		return facilityRepository.saveAndFlush(facility);
	}

	@Override
	@Transactional
	public void removeFacility(Facility facility) {
		facilityRepository.delete(facility);
		
	}
}
