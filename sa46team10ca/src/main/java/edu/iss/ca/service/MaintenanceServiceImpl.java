package edu.iss.ca.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.iss.ca.models.Maintenance;
import edu.iss.ca.repository.MaintenanceRepository;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

	@Resource
	private MaintenanceRepository maintenanceRepository; 
	
	@Override
	public ArrayList<Maintenance> findAllMaintenance() {
		return (ArrayList<Maintenance>)maintenanceRepository.findAll();
	}

	@Override
	public Maintenance findMaintenance(Integer id) {
		return maintenanceRepository.getOne(id);
	}

	@Override
	public Maintenance createMaintenance(Maintenance maintenance) {
		return maintenanceRepository.saveAndFlush(maintenance);
	}

	@Override
	public Maintenance changeMaintenance(Maintenance maintenance) {
		return maintenanceRepository.saveAndFlush(maintenance);	
	}

	@Override
	public void removeMaintenance(Maintenance maintenance) {
		maintenanceRepository.delete(maintenance);		
	}

}
