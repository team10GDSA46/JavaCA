package edu.iss.ca.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.iss.ca.models.TimeSlot;

public interface TimeSlotRepository extends  JpaRepository<TimeSlot, Integer>{

}
