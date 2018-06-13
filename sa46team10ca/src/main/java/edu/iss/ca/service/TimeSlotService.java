package edu.iss.ca.service;

import java.util.ArrayList;

import edu.iss.ca.models.TimeSlot;

public interface TimeSlotService {
	
	ArrayList<TimeSlot> findAllTimeSlot();

	TimeSlot findTimeSlot(Integer id);

	TimeSlot createTimeSlot(TimeSlot timeSlot);

	TimeSlot changeTimeSlot(TimeSlot timeSlot);

	void removeTimeSlot(TimeSlot timeSlot);
}
