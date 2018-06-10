package edu.iss.ca.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Time Slot
 * 
 */

@Entity
@Table(name = "timeslots")
public class TimeSlot {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "timeslotid")
    private int id;
	
	@Column(name = "timeslot")
	private String timeslot;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}

	public TimeSlot(int id, String timeslot) {
		super();
		this.id = id;
		this.timeslot = timeslot;
	}
	
	public TimeSlot() {
	}	

}
