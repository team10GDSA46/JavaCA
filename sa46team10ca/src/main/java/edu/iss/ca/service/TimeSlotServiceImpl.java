package edu.iss.ca.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.ca.models.TimeSlot;
import edu.iss.ca.repository.TimeSlotRepository;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {
	
	@Resource
	private TimeSlotRepository timeSlotRepository;

	@Override
	@Transactional
	public ArrayList<TimeSlot> findAllTimeSlot() {
		ArrayList<TimeSlot> l = (ArrayList<TimeSlot>) timeSlotRepository.findAll();
		return l;
	}

	@Override
	@Transactional
	public TimeSlot findTimeSlot(Integer id) {
		return timeSlotRepository.findOne(id);
	}

	@Override
	@Transactional
	public TimeSlot createTimeSlot(TimeSlot timeSlot) {
		// TODO Auto-generated method stub
		return timeSlotRepository.saveAndFlush(timeSlot);
	}

	@Override
	@Transactional
	public TimeSlot changeTimeSlot(TimeSlot timeSlot) {
		// TODO Auto-generated method stub
		return timeSlotRepository.saveAndFlush(timeSlot);
	}

	@Override
	@Transactional
	public void removeTimeSlot(TimeSlot timeSlot) {
		timeSlotRepository.delete(timeSlot);
		
	}

}
