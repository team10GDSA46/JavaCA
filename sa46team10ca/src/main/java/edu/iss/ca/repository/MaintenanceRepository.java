package edu.iss.ca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.iss.ca.models.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {

}
