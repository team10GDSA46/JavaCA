package edu.iss.ca.service;

import java.util.ArrayList;
import java.util.Date;

import edu.iss.ca.models.Maintenance;

public interface MaintenanceService {
	
	ArrayList<Maintenance> findAllMaintenance();

	Maintenance findMaintenance(Integer id);

	Maintenance createMaintenance(Maintenance maintenance);

	Maintenance changeMaintenance(Maintenance maintenance);

	void removeMaintenance(Maintenance maintenance);

	ArrayList<Integer> findSlotsUnderMaintenance(Date date, Integer facId);
}
