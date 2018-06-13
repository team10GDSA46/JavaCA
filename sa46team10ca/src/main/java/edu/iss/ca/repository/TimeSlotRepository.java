package edu.iss.ca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.iss.ca.models.TimeSlot;

public interface TimeSlotRepository extends  JpaRepository<TimeSlot, Integer>{

}
