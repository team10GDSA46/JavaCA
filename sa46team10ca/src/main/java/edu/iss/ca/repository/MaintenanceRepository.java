package edu.iss.ca.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.ca.models.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
	@Query("SELECT distinct m.timeslot.id from Maintenance m where m.date =:date and m.facility.facilityid =:fid")
	ArrayList<Integer> findSlotsUnderMaintenance(@Param("date") Date date, @Param("fid") Integer fid);
}
